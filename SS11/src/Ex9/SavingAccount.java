package Ex9;

public class SavingAccount extends BankAccount{

    public SavingAccount(double i) {
        super();
    }

    @Override
    void withdraw(double amount) {
        if(balance  >= amount){
            balance -= amount;
        }else{
            System.out.println("Số tiền vượt quá số dư");
        }
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
