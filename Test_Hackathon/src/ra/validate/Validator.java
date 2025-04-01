package ra.validate;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static String validateCustomerId(Scanner scanner,String message) {
        do {
            System.out.println(message);
            String regex = "C+//d{4}";
            String newId = scanner.nextLine().trim();
            if (newId.matches(regex)) {
                return newId;
            }
            System.err.println("ID nhập vào không hợp lệ , vui lòng nhập lại");
        } while (true);
    }

    public static int validateInt(Scanner scanner, String message) {
        do {
            System.out.println(message);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Dữ liệu điền vào ko hợp lệ! Vui lòng nhập lại");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static String validateString(Scanner scanner, String message, int maxLenght, int minLenght) {
        do {
            System.out.println(message);
            try {
                String newString = scanner.nextLine().trim();
                if (newString.length() < minLenght || newString.length() > maxLenght || newString.isEmpty()) {
                    System.err.println("Độ dài không hợp lệ!Mời nhập lại");
                }
                return newString;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static String validateEmail(Scanner scanner, String message) {
        do {
            System.out.println(message);
            try {
                String newEmail = scanner.nextLine().trim();
                if (!newEmail.matches("")) {
                    System.out.println("Email không hợp lệ, vui lòng nhập lại!");
                }
                return newEmail;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static boolean validateGender(Scanner scanner, String message) {
        do {
            System.out.println(message);
            try {
                String newGender = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
                if (newGender.equals("nam")) {
                    return true;
                } else if (newGender.equals("nữ")) {
                    return false;
                } else System.err.println("Giới tính nhập vào không hợp lệ! Vui lòng nhập lại");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static String validateDate(Scanner scanner, String message) {
        do {
            System.out.println(message);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String newDate = scanner.nextLine().trim();

        } while (true);
    }
}
