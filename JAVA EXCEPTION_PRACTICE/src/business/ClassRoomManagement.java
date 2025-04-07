package business;

import entity.ClassRoom;
import entity.Course;
import entity.Student;
import entity.Teacher;
import util.Validator;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ClassRoomManagement {
    private List<ClassRoom> classRooms;
    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Student> students;

    public ClassRoomManagement(List<ClassRoom> classRooms, List<Course> courses, List<Teacher> teachers, List<Student> students) {
        this.classRooms = classRooms;
        this.courses = courses;
        this.teachers = teachers;
        this.students = students;
    }

    public void listClassRooms() {
        classRooms.stream()
                .sorted(Comparator.comparing(ClassRoom::getCreated).reversed())
                .forEach(ClassRoom::display); // Sử dụng display()
    }

    public void addClassRoom(Scanner scanner) {
        ClassRoom newClass = new ClassRoom(null, null, 0, new java.util.ArrayList<>(), null, null); // Khởi tạo với giá trị mặc định
        newClass.inputData(scanner); // Sử dụng inputData để nhập thông tin
        Course course = courses.stream().filter(c -> c.getCourseId().equals(newClass.getCourseId())).findFirst().orElse(null);
        Teacher teacher = teachers.stream().filter(t -> t.getTeacherId() == newClass.getTeacherId()).findFirst().orElse(null);
        if (course != null && teacher != null) {
            classRooms.add(newClass);
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Khóa học hoặc giảng viên không tồn tại!");
        }
    }

    public void updateClassRoom(Scanner scanner) {
        int classId = Validator.validateInt("Nhập mã lớp học cần cập nhật: ", scanner, 1);
        ClassRoom classRoom = classRooms.stream().filter(c -> c.getClassroomId() == classId).findFirst().orElse(null);
        if (classRoom != null && !"CLOSE".equals(classRoom.getStatus())) {
            classRoom.setClassRoomName(Validator.validateString("Nhập tên mới: ", scanner, 15, 50));
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không thể cập nhật vì trạng thái CLOSE hoặc không tìm thấy!");
        }
    }

    public void deleteClassRoom(Scanner scanner) {
        int classId = Validator.validateInt("Nhập mã lớp học cần xóa: ", scanner, 1);
        ClassRoom toDelete = classRooms.stream().filter(c -> c.getClassroomId() == classId).findFirst().orElse(null);
        if (toDelete != null && toDelete.getListStudents().isEmpty()) {
            classRooms.remove(toDelete);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không thể xóa vì lớp đã có sinh viên hoặc không tồn tại!");
        }
    }

    public void assignTeacher(Scanner scanner) {
        int classId = Validator.validateInt("Nhập mã lớp học: ", scanner, 1);
        int teacherId = Validator.validateInt("Nhập mã giảng viên: ", scanner, 1);
        ClassRoom classToAssign = classRooms.stream().filter(c -> c.getClassroomId() == classId).findFirst().orElse(null);
        Teacher teacher = teachers.stream().filter(t -> t.getTeacherId() == teacherId).findFirst().orElse(null);
        if (classToAssign != null && teacher != null) {
            classToAssign.setTeacherId(teacherId);
            System.out.println("Phân công thành công!");
        } else {
            System.out.println("Lớp học hoặc giảng viên không tồn tại!");
        }
    }

    public void addStudentToClass(Scanner scanner) {
        int classId = Validator.validateInt("Nhập mã lớp học: ", scanner, 1);
        String studentId = Validator.validateID("Nhập mã sinh viên (SVxxx): ", scanner, "student");
        ClassRoom classToAdd = classRooms.stream().filter(c -> c.getClassroomId() == classId).findFirst().orElse(null);
        Student studentToAdd = students.stream().filter(s -> s.getStudentId().equals(studentId)).findFirst().orElse(null);
        if (classToAdd != null && studentToAdd != null) {
            classToAdd.getListStudents().add(studentToAdd);
            System.out.println("Thêm sinh viên thành công!");
        } else {
            System.out.println("Lớp học hoặc sinh viên không tồn tại!");
        }
    }

    public void updateClassStatus(Scanner scanner) {
        int classId = Validator.validateInt("Nhập mã lớp học: ", scanner, 1);
        ClassRoom classToUpdate = classRooms.stream().filter(c -> c.getClassroomId() == classId).findFirst().orElse(null);
        if (classToUpdate != null) {
            String newStatus = Validator.validateStatusEnum("Chọn trạng thái mới: ", scanner);
            classToUpdate.setStatus(newStatus);
            System.out.println("Cập nhật trạng thái thành công!");
        } else {
            System.out.println("Không tìm thấy lớp học!");
        }
    }
}