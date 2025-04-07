package business;

import entity.Student;
import util.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private List<Student> students;

    public StudentManagement(List<Student> students) {
        this.students = students;
    }

    public void listStudents() {
        students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(s -> System.out.println(s.getStudentId() + " - " + s.getName()));
    }

    public void addStudent(Scanner scanner) {
        Student  newStudent = new Student();
        newStudent.inputData(scanner);
        students.add(newStudent);
        System.out.println("Thêm thành công!");
    }

    public void updateStudent(Scanner scanner) {
        String updateId = Validator.validateID("Nhập ID sinh viên cần cập nhật: ", scanner, "student");
        Student student = students.stream().filter(s -> s.getStudentId().equals(updateId)).findFirst().orElse(null);
        if (student != null) {
            student.setName(Validator.validateString("Nhập tên mới: ", scanner, 2, 50));
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên!");
        }
    }

    public void deleteStudent(Scanner scanner) {
        String deleteId = Validator.validateID("Nhập ID sinh viên cần xóa: ", scanner, "student");
        Student toDelete = students.stream().filter(s -> s.getStudentId().equals(deleteId)).findFirst().orElse(null);
        if (toDelete != null) {
            students.remove(toDelete);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không thể xóa vì sinh viên đã đăng ký khóa học hoặc không tồn tại!");
        }
    }
}