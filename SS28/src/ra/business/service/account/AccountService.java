package ra.business.service.account;



import ra.business.model.Account;
import ra.business.service.AppService;

import java.util.List;

public interface AccountService extends AppService {
    int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);

    List<Account> getAllAccounts();

    boolean createAccount(Account account);

    boolean updateAccount(Account account);

    boolean deleteAccount(int id);

    double getBalanceById(int accountId);

    Account findById(int id);
}
