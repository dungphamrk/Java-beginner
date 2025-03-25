package Ex10;

import java.util.Map;
import java.util.Scanner;

import static Ex10.EmployeeManager.employees;

public class EmployeeBusiness {
    public static void addEmployee(Scanner scanner) {
        System.out.print("Nhập số lượng nhân viên cần nhập thông tin: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập tên nhân viên: ");
            String name = scanner.nextLine();

            double salary;
            do {
                System.out.print("Nhập lương nhân viên: ");
                salary = Double.parseDouble(scanner.nextLine());
                if (salary < 0) {
                    System.err.println("Lương không được là số âm. Vui lòng nhập lại");
                }
            } while (salary < 0);
            Employee employee = new Employee(name, salary);
            employees.put(employee.getId(), employee);
        }
    }

    public static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Không có nhân viên nào trong danh sách.");
            return;
        }
        System.out.println("Danh sách nhân viên:");
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    public static void calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees.values()) {
            totalSalary += employee.getSalary();
        }
        System.out.println("Tổng lương của tất cả nhân viên: " + totalSalary);
    }

    public static void averageSalary() {
        if (employees.isEmpty()) {
            System.out.println("Không có nhân viên nào để tính lương trung bình.");
            return;
        }
        double totalSalary = 0;
        for (Employee employee : employees.values()) {
            totalSalary += employee.getSalary();
        }
        double average = totalSalary / employees.size();
        System.out.println("Lương trung bình của tất cả nhân viên:  " + average);
    }

    public static void highestPaidEmployee() {
        Employee highest = employees.values().iterator().next();
        for (Employee employee : employees.values()) {
            if (employee.getSalary() > highest.getSalary()) {
                highest = employee;
            }
        }
        System.out.println("Nhân viên có lương cao nhất: " + highest);
    }

    public static void lowestPaidEmployee() {
        Employee lowest = employees.values().iterator().next();
        for (Employee employee : employees.values()) {
            if (employee.getSalary() < lowest.getSalary()) {
                lowest = employee;
            }
        }
        System.out.println("Nhân viên có lương thấp nhất: " + lowest);
    }
}
