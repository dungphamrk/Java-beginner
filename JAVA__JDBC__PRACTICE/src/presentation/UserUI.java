package presentation;

import business.service.user.UserService;
import business.service.user.UserServiceImp;
import validate.Validator;

import java.util.Scanner;

public class UserUI {

    public static void displayMainMenu(Scanner scanner) {
        do {
            System.out.println("***************MAIN MENU**************");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Thoát chương trình");
            int choice = Validator.validateChoice(scanner);
            switch (choice) {
                case 1:
                    if (displayLoginMenu(scanner)) {
                        displayUserMenu(scanner);
                    }
                    break;
                case 2:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.err.println("Vui lòng chọn 1 hoặc 2");
            }
        } while (true);
    }

    private static boolean displayLoginMenu(Scanner scanner) {
        UserService userService = new UserServiceImp();
        System.out.println("***************LOGIN MENU**************");
        System.out.println("Nhập tên đăng nhập:");
        String username = scanner.nextLine();
        System.out.println("Nhập mật khẩu:");
        String password = scanner.nextLine();
        boolean result = userService.login(username, password);
        if (result) {
            System.out.println("Đăng nhập thành công!");
            return true;
        } else {
            System.err.println("Tên đăng nhập hoặc mật khẩu không đúng");
            return false;
        }
    }

    private static void displayUserMenu(Scanner scanner) {
        UserService userService = new UserServiceImp();
        do {
            System.out.println("***************USER MENU**************");
            System.out.println("1. Quản lý nhân viên");
            System.out.println("2. Quản lý phòng ban");
            System.out.println("3. Đăng xuất");
            int choice = Validator.validateChoice(scanner);
            switch (choice) {
                case 1:
                    EmployeeUI.displayEmployeeMenu(scanner);
                    break;
                case 2:
                    DepartmentUI.displayDepartmentMenu(scanner);
                    break;
                case 3:
                    displayLogoutMenu(scanner);
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-3");
            }
        } while (true);
    }

    public static void displayLogoutMenu(Scanner scanner) {
        UserService userService = new UserServiceImp();
        System.out.println("Bạn có chắc chắn muốn đăng xuất? (1: Có, 2: Không)");
        int choice = Validator.validateChoice(scanner);
        if (choice == 1) {
            userService.logout();
            System.out.println("Đăng xuất thành công!");

        } else {
            System.out.println("Hủy đăng xuất.");
        }
    }
}