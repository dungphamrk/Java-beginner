package ra.business.service.fundstranfer;

import ra.business.dao.fundtransfer.FundsTransferDao;
import ra.business.dao.fundtransfer.FundsTransferDaoImp;
import ra.business.model.FundsTransfer;
import ra.business.model.TransactionStatus;

import java.time.LocalDateTime;
import java.util.List;

public class FundsTransferServiceImp implements FundsTransferService {
    private final FundsTransferDao fundsTransferDao;

    public FundsTransferServiceImp() {
        fundsTransferDao = new FundsTransferDaoImp();
    }

    @Override
    public boolean saveTransaction(FundsTransfer transaction) {
        return fundsTransferDao.saveTransaction(transaction);
    }

    @Override
    public List<FundsTransfer> getTransactionHistory() {
        return fundsTransferDao.getTransactionHistory();
    }

    @Override
    public double getTotalSentAmount(LocalDateTime startDate, LocalDateTime endDate) {
        List<FundsTransfer> transactions = fundsTransferDao.getTransactionsByDateRange(startDate, endDate);
        return transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .mapToDouble(FundsTransfer::getAmount)
                .sum();
    }

    @Override
    public double getTotalReceivedAmountByAccount(int accountId) {
        List<FundsTransfer> transactions = fundsTransferDao.getTransactionsByReceiverId(accountId);
        return transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .mapToDouble(FundsTransfer::getAmount)
                .sum();
    }

    @Override
    public int getSuccessfulTransactionsCount(LocalDateTime startDate, LocalDateTime endDate) {
        List<FundsTransfer> transactions = fundsTransferDao.getTransactionsByDateRange(startDate, endDate);
        return (int) transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .count();
    }
}