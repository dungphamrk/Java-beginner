package Ex9;

public class CheckingAccount extends BankAccount{
    public CheckingAccount(double i) {
        super();
    }

    @Override
    void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    void deposit(double amount) {
        if(amount<0){
            System.out.println("Số tiền nạp vào ko hợp lệ");
            return;
        }
        balance+=amount;
        System.out.println("Nạp tiền thành công");
    }

    @Override
    void displayBalance() {
        System.out.println("Số dư tài khoản hiện tại: " + balance);
    }
}
