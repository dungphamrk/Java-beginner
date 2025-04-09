package ra.business.service.fundstranfer;
import ra.business.dao.account.AccountDao;
import ra.business.dao.account.AccountDaoImp;
import ra.business.model.FundsTransfer;
import ra.business.model.TransactionStatus;
import java.time.LocalDateTime;
import java.util.List;
public class FundsTransferServiceImp implements FundsTransferService {
    private final AccountDao accountDao;
    public FundsTransferServiceImp() {
        accountDao = new AccountDaoImp();
    }
    @Override
    public boolean saveTransaction(FundsTransfer transaction) {
        return accountDao.saveTransaction(transaction);
    }

    @Override
    public List<FundsTransfer> getTransactionHistory() {
        return accountDao.getTransactionHistory();
    }

    @Override
    public double getTotalSentAmount(LocalDateTime startDate, LocalDateTime endDate) {
        List<FundsTransfer> transactions = getTransactionHistory();
        return transactions.stream()
                .filter(t -> t.getTransactionDate().isAfter(startDate) &&
                        t.getTransactionDate().isBefore(endDate) &&
                        t.getStatus() == TransactionStatus.SUCCESSFUL)
                .mapToDouble(FundsTransfer::getAmount)
                .sum();
    }

    @Override
    public double getTotalReceivedAmountByAccount(int accountId) {
        List<FundsTransfer> transactions = getTransactionHistory();
        return transactions.stream()
                .filter(t -> t.getReceiverId() == accountId &&
                        t.getStatus() == TransactionStatus.SUCCESSFUL)
                .mapToDouble(FundsTransfer::getAmount)
                .sum();
    }

    @Override
    public int getSuccessfulTransactionsCount(LocalDateTime startDate, LocalDateTime endDate) {
        List<FundsTransfer> transactions = getTransactionHistory();
        return (int) transactions.stream()
                .filter(t -> t.getTransactionDate().isAfter(startDate) &&
                        t.getTransactionDate().isBefore(endDate) &&
                        t.getStatus() == TransactionStatus.SUCCESSFUL)
                .count();
    }
}
