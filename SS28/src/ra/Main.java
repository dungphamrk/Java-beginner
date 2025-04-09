package ra;

import ra.presentation.AccountUI;
import ra.presentation.FundsTransferUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountUI.displayAccountMenu(scanner);
        FundsTransferUI.displayFundsTransferMenu(scanner);
    }
}

