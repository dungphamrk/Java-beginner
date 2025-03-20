package Ex10;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Hiển thị danh sách sinh viên theo phân loại GPA");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    printStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    classifyStudents();
                    break;
                case 5:
                    System.out.println("Chương trình kết thúc!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        }
    }

    public static void addStudents() {
        System.out.print("Nhập số lượng sinh viên: ");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.print("Nhập mã sinh viên: ");
            String id = scanner.nextLine();
            System.out.print("Nhập họ và tên: ");
            String name = scanner.nextLine();
            System.out.print("Nhập điểm GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());
            students.add(new Student(id, name, gpa));
        }
    }

    public static void printStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        System.out.println("\nDanh sách sinh viên:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void searchStudent() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.name.equalsIgnoreCase(searchName)) {
                System.out.println("Tìm thấy: " + s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào có tên: " + searchName);
        }
    }

    public static void classifyStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        System.out.println("\nDanh sách sinh viên theo phân loại:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}