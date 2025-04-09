package ra.business.dao.account;

import ra.business.config.ConnectionDB;
import ra.business.model.Account;
import ra.business.model.AccountStatus;
import ra.business.model.FundsTransfer;
import ra.business.model.TransactionStatus;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class AccountDaoImp implements AccountDao {
    @Override
    public double getBalanceById(int accountId) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_balance_by_id(?, ?)}");
            callSt.setInt(1, accountId);
            callSt.registerOutParameter(2, Types.DOUBLE);
            callSt.execute();
            return callSt.getDouble(2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_accounts()}");
            rs = callSt.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("acc_id"));
                account.setName(rs.getString("acc_name"));
                account.setBalance(rs.getDouble("acc_balance"));
                account.setStatus(AccountStatus.valueOf(rs.getString("acc_status").toUpperCase()));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return accounts;
    }

    @Override
    public boolean createAccount(Account account) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_account(?, ?, ?)}");
            callSt.setString(1, account.getName());
            callSt.setDouble(2, account.getBalance());
            callSt.setString(3, account.getStatus().name().toLowerCase());
            int result = callSt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_account(?, ?, ?)}");
            callSt.setInt(1, account.getId());
            callSt.setString(2, account.getName());
            callSt.setString(3, account.getStatus().name().toLowerCase());
            int result = callSt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean deleteAccount(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_account(?)}");
            callSt.setInt(1, id);
            int result = callSt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public Account findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_account_by_id(?)}");
            callSt.setInt(1, id);
            rs = callSt.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("acc_id"));
                account.setName(rs.getString("acc_name"));
                account.setBalance(rs.getDouble("acc_balance"));
                account.setStatus(AccountStatus.valueOf(rs.getString("acc_status").toUpperCase()));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return null;
    }
    @Override
    public boolean saveTransaction(FundsTransfer transaction) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call save_transaction(?,?,?,?,?,?,?)}");
            callSt.setInt(1, transaction.getSenderId());
            callSt.setString(2, transaction.getSenderName());
            callSt.setInt(3, transaction.getReceiverId());
            callSt.setString(4, transaction.getReceiverName());
            callSt.setDouble(5, transaction.getAmount());
            callSt.setTimestamp(6, Timestamp.valueOf(transaction.getTransactionDate()));
            callSt.setString(7, transaction.getStatus().name().toLowerCase());
            int result = callSt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId,
                             String accReceiverName, double amount) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call funds_transfer_amount(?,?,?,?,?,?)}");
            callSt.setInt(1, accSenderId);
            callSt.setString(2, accSenderName);
            callSt.setInt(3, accReceiverId);
            callSt.setString(4, accReceiverName);
            callSt.setDouble(5, amount);
            callSt.registerOutParameter(6, Types.INTEGER);
            callSt.execute();

            int result = callSt.getInt(6);
            // Lưu lịch sử giao dịch
            if (result == 4) { // Thành công
                FundsTransfer transaction = new FundsTransfer(
                        accSenderId, accSenderName, accReceiverId, accReceiverName,
                        amount, LocalDateTime.now(), TransactionStatus.SUCCESSFUL
                );
                saveTransaction(transaction);
            }
            conn.commit();
            return result;
        } catch (SQLException e) {
            System.err.println("Có lỗi xảy ra khi chuyển khoản, rollback...");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return 0;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public List<FundsTransfer> getTransactionHistory() {
        List<FundsTransfer> transactions = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_transaction_history()}");
            rs = callSt.executeQuery();
            while (rs.next()) {
                FundsTransfer transaction = new FundsTransfer();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setSenderId(rs.getInt("sender_id"));
                transaction.setSenderName(rs.getString("sender_name"));
                transaction.setReceiverId(rs.getInt("receiver_id"));
                transaction.setReceiverName(rs.getString("receiver_name"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setTransactionDate(rs.getTimestamp("transaction_date").toLocalDateTime());
                transaction.setStatus(TransactionStatus.valueOf(rs.getString("status").toUpperCase()));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return transactions;
    }
}