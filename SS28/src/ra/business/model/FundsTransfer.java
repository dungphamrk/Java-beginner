package ra.business.model;

import java.time.LocalDateTime;

public class FundsTransfer {
    private int transactionId;
    private int senderId;
    private String senderName;
    private int receiverId;
    private String receiverName;
    private double amount;
    private LocalDateTime transactionDate;
    private TransactionStatus status;

    public FundsTransfer() {
    }

    public FundsTransfer(int senderId, String senderName, int receiverId, String receiverName,
                         double amount, LocalDateTime transactionDate, TransactionStatus status) {
        this.senderId = senderId;
        this.senderName = senderName;
        this.receiverId = receiverId;
        this.receiverName = receiverName;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.status = status;
    }

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FundsTransfer{" +
                "transactionId=" + transactionId +
                ", senderId=" + senderId +
                ", senderName='" + senderName + '\'' +
                ", receiverId=" + receiverId +
                ", receiverName='" + receiverName + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", status=" + status +
                '}';
    }
}