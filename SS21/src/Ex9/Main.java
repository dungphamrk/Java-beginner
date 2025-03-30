package Ex9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("1", 3333));
        accounts.add(new BankAccount("2", 411));
        accounts.add(new BankAccount("3", 502230));
        accounts.add(new BankAccount("4", 3321));

        try {
            accounts.get(0).Deposit(200);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            accounts.get(1).Withdraw(99900);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            accounts.get(2).Transfer(accounts.get(3), 200);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            accounts.get(0).Withdraw(6000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            accounts.get(1).Deposit(-600);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            accounts.get(2).Transfer(null, 400);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
