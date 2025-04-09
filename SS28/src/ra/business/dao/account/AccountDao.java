package ra.business.dao.account;

import ra.business.dao.AppDao;
import ra.business.model.Account;
import ra.business.model.FundsTransfer;

import java.util.List;

public interface AccountDao extends AppDao {
    int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);
    double getBalanceById(int accountId);

    List<Account> getAllAccounts();
    boolean createAccount(Account account);
    boolean updateAccount(Account account);
    boolean deleteAccount(int id);
    Account findById(int id);
    boolean saveTransaction(FundsTransfer transaction);
    List<FundsTransfer> getTransactionHistory();
}
