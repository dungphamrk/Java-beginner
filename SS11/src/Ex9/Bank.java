package Ex9;

public class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank() {
        accounts = new BankAccount[10]; // Chứa tối đa 10 tài khoản
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count++] = account;
            System.out.println("Tài khoản đã được thêm vào ngân hàng.");
        } else {
            System.out.println("Ngân hàng đã đầy, không thể thêm tài khoản mới.");
        }
    }

    public void displayBalance() {
        if (count == 0) {
            System.out.println("Ngân hàng không có tài khoản nào.");
            return;
        }
        System.out.println("\nDanh sách số dư tài khoản:");
        for (int i = 0; i < count; i++) {
           accounts[i].displayBalance();
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount acc1 = new SavingAccount(500000);
        BankAccount acc2 = new CheckingAccount(1000000);
        BankAccount acc3 = new SavingAccount(200000);

        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(acc3);
        bank.accounts[0].deposit(100);
        bank.accounts[1].withdraw(100);
        bank.accounts[2].deposit(100);
        bank.displayBalance();
    }
}

