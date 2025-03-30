package Ex9;

public class BankAccount {
    private String accountId;
    private double balance;
    public BankAccount() {
    }
    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void Deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền gửi không hợp lệ.");
        }
        balance += amount;
        System.out.println("Đã gửi: " +amount+ ". Số dư hiện tại: " +balance);
    }

    public void Withdraw(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền rút không hợp lệ.");
        } else if (amount > balance) {
            throw new IllegalArgumentException("Số tiền rút không đc lớn hơn số dư");
        }
        balance -= amount;
        System.out.println("Đã rút tiền: " +amount+ ". Số dư hiện tại:  " +balance);
    }

    public void Transfer(BankAccount account, double amount) throws IllegalArgumentException {
        if (account == null) {
            throw new IllegalArgumentException("Tài khoản chuyển tiền không tồn tại.");
        }
        Withdraw(amount);
        account.Deposit(amount);
        System.out.println("Chuyển tiền: "+amount+ " từ tài khoản " +this.accountId+ " đến tài khoản " +account.getAccountId());
    }
}
