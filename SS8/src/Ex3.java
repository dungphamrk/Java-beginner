import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email, password;

        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,6}$";
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%!&*]).{8,}$";

        while (true) {
            System.out.print("Nhập email: ");
            email = sc.nextLine();
            if (email.matches(emailRegex))
                break;
            System.out.println("Email không hợp lệ! Vui lòng nhập lại.");
        }

        while (true) {
            System.out.print("Nhập mật khẩu: ");
            password = sc.nextLine();
            if (password.matches(passwordRegex))
                break;
            System.out.println("Mật khẩu không hợp lệ!Vui lòng nhập lại.");
        }

        System.out.println("Email và mật khẩu hợp lệ!");
    }
}
