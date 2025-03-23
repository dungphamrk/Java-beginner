package ra.presentation;

import ra.business.StudentBusiness;

import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentBusiness business = new StudentBusiness(scanner);

        while (true) {
            displayMenu();
            System.out.print("Chọn chức năng (0-6): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    business.displayAllStudents();
                    break;
                case 2:
                    business.addNewStudents();
                    break;
                case 3:
                    business.editStudent();
                    break;
                case 4:
                    business.deleteStudent();
                    break;
                case 5:
                    business.searchStudent();
                    break;
                case 6:
                    business.sortStudents();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("----------------------------Student Menu----------------------------");
        System.out.println("1. Hiển thị danh sách sinh viên");
        System.out.println("2. Thêm mới sinh viên");
        System.out.println("3. Chỉnh sửa thông tin sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.println("5. Tìm kiếm sinh viên");
        System.out.println("6. Sắp xếp");
        System.out.println("0. Thoát chương trình");
        System.out.println("------------------------------------------------------------------");
    }
}