package ra.business.service.fundstranfer;

import ra.business.model.FundsTransfer;
import java.time.LocalDateTime;
import java.util.List;

public interface FundsTransferService {
    boolean saveTransaction(FundsTransfer transaction);
    List<FundsTransfer> getTransactionHistory();
    double getTotalSentAmount(LocalDateTime startDate, LocalDateTime endDate);
    double getTotalReceivedAmountByAccount(int accountId);
    int getSuccessfulTransactionsCount(LocalDateTime startDate, LocalDateTime endDate);
}
