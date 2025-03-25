package Ex10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManager {
    public static Map<Integer, Employee> employees = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        employeeMenu(scanner);
        return;
    }
    private static void employeeMenu(Scanner scanner) {
        do {
            System.out.println("------------------------- Quản lý nhân viên ---------------------------");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Tính tổng lương của tất cả nhân viên");
            System.out.println("4. Tính lương trung bình");
            System.out.println("5. Tìm nhân viên có lương cao nhất");
            System.out.println("6. Tìm nhân viên có lương thấp nhất");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    EmployeeBusiness.addEmployee(scanner);
                    break;
                case 2:
                    EmployeeBusiness.displayEmployees();
                    break;
                case 3:
                    EmployeeBusiness.calculateTotalSalary();
                    break;
                case 4:
                    EmployeeBusiness.averageSalary();
                    break;
                case 5:
                    EmployeeBusiness.highestPaidEmployee();
                    break;
                case 6:
                    EmployeeBusiness.lowestPaidEmployee();
                    break;
                case 7:
                    return;
            }
        }while (true);
    }

}
