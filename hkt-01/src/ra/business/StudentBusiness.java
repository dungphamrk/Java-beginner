package ra.business;

import ra.entity.Student;
import ra.validate.StudentValidate;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentBusiness {
    private Scanner scanner;

    public StudentBusiness(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayAllStudents() {
        if (Student.getStudents().isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        Student.getStudents().forEach(Student::displayData);
    }

    public void addNewStudents() {
        System.out.print("Nhập số lượng sinh viên cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n <= 0) {
            System.out.println("Số lượng không hợp lệ!");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            new Student().inputData();
        }
        System.out.println("Thêm mới thành công!");
    }

    public void editStudent() {
        System.out.print("Nhập mã sinh viên cần sửa: ");
        String id = scanner.nextLine().trim();
        Student student = Student.getStudents().stream()
                .filter(s -> s.getStudentId().equals(id))
                .findFirst().orElse(null);

        if (student == null) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }

        student.displayData();
        System.out.println("Chọn thuộc tính cần sửa:");
        System.out.println("1. Tên | 2. Ngày sinh | 3. SĐT | 4. Giới tính | 5. Email | 6. Ngành | 7. Lớp | 8. GPA");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1: student.setStudentName(StudentValidate.inputStudentName(scanner)); break;
            case 2: student.setBirthday(StudentValidate.inputBirthday(scanner)); break;
            case 3: student.setPhoneNumber(StudentValidate.inputPhoneNumber(scanner)); break;
            case 4: student.setSex(StudentValidate.inputSex(scanner)); break;
            case 5: student.setEmail(StudentValidate.inputEmail(scanner)); break;
            case 6: student.setMajor(StudentValidate.inputMajor(scanner)); break;
            case 7: student.setClassName(StudentValidate.inputClassName(scanner)); break;
            case 8: student.setGpa(StudentValidate.inputGpa(scanner)); break;
            default: System.out.println("Lựa chọn không hợp lệ!"); return;
        }
        System.out.println("Cập nhật thành công!");
    }

    public void deleteStudent() {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine().trim();
        Student student = Student.getStudents().stream()
                .filter(s -> s.getStudentId().equals(id))
                .findFirst().orElse(null);

        if (student == null) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }

        student.displayData();
        System.out.print("Bạn có chắc chắn muốn xóa? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            Student.getStudents().remove(student);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Hủy bỏ thao tác!");
        }
    }

    public void searchStudent() {
        System.out.println("1. Tìm theo tên | 2. Tìm theo lớp | 3. Tìm theo khoảng GPA");
        int choice = Integer.parseInt(scanner.nextLine());
        List<Student> results;

        switch (choice) {
            case 1:
                System.out.print("Nhập tên cần tìm: ");
                String name = scanner.nextLine().trim();
                results = Student.getStudents().stream()
                        .filter(s -> s.getStudentName().toLowerCase().contains(name.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            case 2:
                System.out.print("Nhập tên lớp cần tìm: ");
                String className = scanner.nextLine().trim();
                results = Student.getStudents().stream()
                        .filter(s -> s.getClassName().equalsIgnoreCase(className))
                        .collect(Collectors.toList());
                break;
            case 3:
                System.out.print("Nhập GPA từ: ");
                float fromGpa = Float.parseFloat(scanner.nextLine());
                System.out.print("Nhập GPA đến: ");
                float toGpa = Float.parseFloat(scanner.nextLine());
                results = Student.getStudents().stream()
                        .filter(s -> s.getGpa() >= fromGpa && s.getGpa() <= toGpa)
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        if (results.isEmpty()) {
            System.out.println("Không tìm thấy kết quả phù hợp!");
        } else {
            results.forEach(Student::displayData);
        }
    }

    public void sortStudents() {
        System.out.println("1. Tên tăng dần | 2. Tên giảm dần | 3. GPA tăng dần | 4. GPA giảm dần");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Student.getStudents().sort(Comparator.comparing(Student::getStudentName));
                break;
            case 2:
                Student.getStudents().sort(Comparator.comparing(Student::getStudentName).reversed());
                break;
            case 3:
                Student.getStudents().sort(Comparator.comparing(Student::getGpa));
                break;
            case 4:
                Student.getStudents().sort(Comparator.comparing(Student::getGpa).reversed());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }
        System.out.println("Kết quả sắp xếp:");
        displayAllStudents();
    }
}