package util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator<T> {
    public static String validateID(String message, Scanner scanner, String type) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Không được để trống!");
                continue;
            }

            boolean isValid = switch (type.toLowerCase()) {
                case "course" -> Pattern.matches("^C\\w{4}$", input);
                case "student" -> Pattern.matches("^SV\\w{3}$", input);
                default -> false;
            };

            if (!isValid) {
                System.out.println("ID không hợp lệ. Vui lòng nhập lại!");
            } else {
                break;
            }
        }
        return input;
    }
    public static String validateString(String message, Scanner scanner, int minLength, int maxLength) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Không được để trống!");
            } else if (input.length() < minLength) {
                System.out.println("Chuỗi quá ngắn! Tối thiểu " + minLength + " ký tự.");
            } else if (input.length() > maxLength) {
                System.out.println("Chuỗi quá dài! Tối đa " + maxLength + " ký tự.");
            } else {
                break;
            }
        }
        return input;
    }
    public static boolean validateBoolean(String message, Scanner scanner) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("true")) {
                return true;
            } else if (input.equals("false")) {
                return false;
            } else {
                System.out.println("Vui lòng nhập đúng 'true' hoặc 'false'.");
            }
        }
    }
    public static String validatePhone(String message, Scanner scanner) {
        String regex = "^(0|\\+84)(\\d{9})$";
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Không được để trống!");
            } else if (!Pattern.matches(regex, input)) {
                System.out.println("Số điện thoại không hợp lệ! Vui lòng nhập theo định dạng Việt Nam.");
            } else {
                return input;
            }
        }
    }
    public static LocalDate validateDate(String message, Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        while (true) {
            System.out.print(message);
            LocalDate input = LocalDate.parse(scanner.nextLine().trim());
            try {
                Date date = sdf.parse(String.valueOf(input));
                return input;
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ! Định dạng đúng là dd/MM/yyyy (VD: 01/01/2024)");
            }
        }
    }
    public static String validateDateTime(String message, Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setLenient(false);

        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                sdf.parse(input);
                return input;
            } catch (Exception e) {
                System.out.println("Thời gian không hợp lệ! Định dạng đúng là yyyy-MM-dd HH:mm:ss (VD: 2024-12-31 15:00:00)");
            }
        }
    }
    public static String validateStatusEnum(String message, Scanner scanner) {
        while (true) {
            System.out.println(message);
            System.out.println("1. PENDING");
            System.out.println("2. PROGRESS");
            System.out.println("3. CLOSE");
            System.out.print("Vui lòng chọn (1-3): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    return "PENDING";
                case "2":
                    return "PROGRESS";
                case "3":
                    return "CLOSE";
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn 1, 2 hoặc 3.");
            }
        }
    }
    public static int validateInt(String message, Scanner scanner, int min) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min) return value;
                System.out.println("Giá trị phải >= " + min);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    public static double validateDouble(String message, Scanner scanner, double min) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= min) return value;
                System.out.println("Giá trị phải >= " + min);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }
    }

}
