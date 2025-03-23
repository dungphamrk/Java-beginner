package ra.validate;

import ra.entity.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentValidate {
    private static final String PHONE_REGEX = "^(0[35789])[0-9]{8}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String inputStudentName(Scanner scanner) {
        String name;
        do {
            System.out.print("Nhập tên sinh viên (không để trống): ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) System.out.println("Tên không được để trống!");
        } while (name.isEmpty());
        return name;
    }

    public static String inputBirthday(Scanner scanner) {
        String birthday;
        do {
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            birthday = scanner.nextLine().trim();
            try {
                LocalDate.parse(birthday, DATE_FORMATTER);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày sinh không hợp lệ!");
            }
        } while (true);
        return birthday;
    }

    public static String inputPhoneNumber(Scanner scanner) {
        String phone;
        do {
            System.out.print("Nhập số điện thoại (VD: 0912345678): ");
            phone = scanner.nextLine().trim();
            if (!Pattern.matches(PHONE_REGEX, phone)) {
                System.out.println("Số điện thoại không hợp lệ!");
            }
        } while (!Pattern.matches(PHONE_REGEX, phone));
        return phone;
    }

    public static boolean inputSex(Scanner scanner) {
        System.out.print("Nhập giới tính (true - Nam, false - Nữ): ");
        return Boolean.parseBoolean(scanner.nextLine().trim());
    }

    public static String inputEmail(Scanner scanner) {
        String email;
        do {
            System.out.print("Nhập email (định dạng @gmail.com): ");
            email = scanner.nextLine().trim();
            if (!Pattern.matches(EMAIL_REGEX, email) || Student.getStudents().stream().anyMatch(s -> s.getEmail().equals(email))) {
                System.out.println("Email không hợp lệ hoặc đã tồn tại!");
            }
        } while (!Pattern.matches(EMAIL_REGEX, email) || Student.getStudents().stream().anyMatch(s -> s.getEmail().equals(email)));
        return email;
    }

    public static String inputMajor(Scanner scanner) {
        String major;
        do {
            System.out.print("Nhập ngành học (không để trống): ");
            major = scanner.nextLine().trim();
            if (major.isEmpty()) System.out.println("Ngành học không được để trống!");
        } while (major.isEmpty());
        return major;
    }

    public static String inputClassName(Scanner scanner) {
        String className;
        do {
            System.out.print("Nhập tên lớp (không để trống): ");
            className = scanner.nextLine().trim();
            if (className.isEmpty()) System.out.println("Tên lớp không được để trống!");
        } while (className.isEmpty());
        return className;
    }

    public static float inputGpa(Scanner scanner) {
        float gpa;
        do {
            System.out.print("Nhập điểm GPA (>= 0): ");
            gpa = Float.parseFloat(scanner.nextLine().trim());
            if (gpa < 0) System.out.println("GPA phải lớn hơn hoặc bằng 0!");
        } while (gpa < 0);
        return gpa;
    }
}