package Ex1;

public class Main {
    public static void main(String[] args) {
        Account account1 = Account.getInstance();
        Account account2 = Account.getInstance();
        Account account3 = Account.getInstance();

        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);
        System.out.println("Account 3: " + account3);

        System.out.println("account1 == account2: " + (account1 == account2));
        System.out.println("account2 == account3: " + (account2 == account3));

        account1.setName("John");
        account1.setAge(30);

        System.out.println("\nSau khi thay đổi account1:");
        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);
        System.out.println("Account 3: " + account3);
    }
}