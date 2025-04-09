package ra.business.dao.fundtransfer;

import ra.business.model.FundsTransfer;

import java.time.LocalDateTime;
import java.util.List;

public interface FundsTransferDao {
    boolean saveTransaction(FundsTransfer transaction);
    List<FundsTransfer> getTransactionHistory();
    List<FundsTransfer> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate);
    List<FundsTransfer> getTransactionsByReceiverId(int receiverId);
}