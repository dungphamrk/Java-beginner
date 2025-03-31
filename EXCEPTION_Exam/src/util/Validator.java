package util;

import java.util.Scanner;

public class Validator {
    public int validateInteger(Scanner scanner, String message) {
        do {
            System.out.println(message);
            try {
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.err.println("đây ko phải là số nguyên, nhập lại");
            }
        }while (true);
    }

    public float validateFloat(Scanner scanner, String message) {
        do {
            System.out.println(message);
            try {
                return Float.parseFloat(scanner.nextLine());
            }catch (NumberFormatException e){
                System.err.println("đây ko phải là số kiểu float, nhập lại");
            }
        }while (true);
    }
    public double validateDouble(Scanner scanner, String message) {
        do {
            System.out.println(message);
            try{
                return Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e){
                System.err.println("đây ko phải là số double, nhập lại");
            }
        }while (true);
    }
    public boolean validateBoolean(Scanner scanner, String message) {
        do {
            System.out.println(message);
            try {
                String bool=scanner.nextLine();
                if (bool.equalsIgnoreCase("true") || bool.equalsIgnoreCase("false")) {
                    return true;
                }
                return false;
            }catch (Exception e){
                e.printStackTrace();
            }
        }while (true);
    }
    public String validateString(Scanner scanner, String message, int max, int min) {
        do {
            System.out.println(message);
            try {
                String newString = scanner.nextLine().trim();
                if(newString.length() < min || newString.length() > max){
                    System.err.println("Phải có độ dài trong khoảng "+ max + " và "+ min);
                    continue;
                }
                return newString;
            }catch (Exception e){
                System.err.println("Đây không phải kiểu String");
            }
        }while(true);
    }
    public void validateEmail(Scanner scanner, String message) {
        do {
            System.out.println(message);
            try {
                String newEmail = scanner.nextLine().trim();
                if(newEmail.matches("^.+@.+\\..+")) {
                    return;
                }
                System.err.println("đây ko phải email mời nhập lại");
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        } while (true);
    }
}


