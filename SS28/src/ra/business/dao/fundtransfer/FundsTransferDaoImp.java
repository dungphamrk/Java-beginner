package ra.business.dao.fundtransfer;
import ra.business.config.ConnectionDB;
import ra.business.model.FundsTransfer;
import ra.business.model.TransactionStatus;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FundsTransferDaoImp implements FundsTransferDao {

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

    @Override
    public List<FundsTransfer> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<FundsTransfer> transactions = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_transactions_by_date_range(?,?)}");
            callSt.setTimestamp(1, Timestamp.valueOf(startDate));
            callSt.setTimestamp(2, Timestamp.valueOf(endDate));
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

    @Override
    public List<FundsTransfer> getTransactionsByReceiverId(int receiverId) {
        List<FundsTransfer> transactions = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_transactions_by_receiver_id(?)}");
            callSt.setInt(1, receiverId);
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