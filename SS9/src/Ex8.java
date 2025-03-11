public class Ex8 {
    public static class BankAccount{
        private final String accountNumber;
        private final String accountHolder;
        private double balance;
        public BankAccount(String accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }
        public void deposit(double amount){
            if(amount>0){
                this.balance += amount;
            }else {
                System.out.println("Số tiền nạp vào không hợp lệ");
            }
        }
        public void withdraw(double amount ){
            if(amount>balance){
                System.out.println("Số dư không đủ");
            }else{
                this.balance -= amount;
            }
        }
        public void transfer(double amount,BankAccount recipient){
            if(amount>balance){
                System.out.println("Số dư không đủ");
            }else{
                balance-=amount;
                recipient.balance+=amount;
                System.out.println("Chuyển tiền thành công");
            }
        }
        public void display(){
            System.out.println("Số tài khoản: " + accountNumber);
            System.out.println("Tên chủ tài khoản: " + accountHolder);
            System.out.println("Số dư có trong tài khoản hiện tại: " + balance);
        }

    }
    public static void main(String[] args) {
        BankAccount  a = new BankAccount("123","123",9900.0);
        BankAccount  b = new BankAccount("456","456",100.0);
        a.withdraw(9999);
        b.deposit(1000);
        a.transfer(9999,b);
        a.display();
    }
}
