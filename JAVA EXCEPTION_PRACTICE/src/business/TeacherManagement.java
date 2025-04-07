package business;

import entity.Teacher;
import util.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeacherManagement {
    private List<Teacher> teachers;

    public TeacherManagement(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void listTeachers() {
        teachers.stream()
                .sorted(Comparator.comparing(Teacher::getTeacherId).reversed())
                .forEach(t -> System.out.println(t.getTeacherId() + " - " + t.getName()));
    }

    public void addTeacher(Scanner scanner) {
        Teacher newTeacher =new Teacher();
        newTeacher.inputData(scanner);
        teachers.add(newTeacher);
        System.out.println("Thêm thành công!");
    }

    public void updateTeacher(Scanner scanner) {
        int updateId = Validator.validateInt("Nhập ID giảng viên cần cập nhật: ", scanner,0);
        Teacher teacher = teachers.stream().filter(t -> t.getTeacherId()==updateId).findFirst().orElse(null);
        if (teacher != null) {
            teacher.setName(Validator.validateString("Nhập tên mới: ", scanner, 2, 50));
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy giảng viên!");
        }
    }

    public void deleteTeacher(Scanner scanner) {
        int deleteId = Validator.validateInt("Nhập ID giảng viên cần xóa: ", scanner, 0);
        Teacher toDelete = teachers.stream().filter(t -> t.getTeacherId()==deleteId).findFirst().orElse(null);
        if (toDelete != null ) {
            teachers.remove(toDelete);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không thể xóa vì giảng viên đã được xếp lớp hoặc không tồn tại!");
        }
    }
}