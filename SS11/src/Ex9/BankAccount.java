package Ex9;

public abstract class BankAccount {
    String accountNumber;
    double balance;
    abstract void withdraw(double amount);
    abstract void deposit(double amount);
    abstract void displayBalance();
}
