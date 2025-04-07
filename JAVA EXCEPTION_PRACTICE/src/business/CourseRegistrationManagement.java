package business;

import entity.Course;
import entity.CourseRegistration;
import entity.Student;
import util.Validator;

import java.util.List;
import java.util.Scanner;

public class CourseRegistrationManagement {
    private List<CourseRegistration> registrations;
    private List<Student> students;
    private List<Course> courses;

    public CourseRegistrationManagement(List<CourseRegistration> registrations, List<Student> students, List<Course> courses) {
        this.registrations = registrations;
        this.students = students;
        this.courses = courses;
    }

    public void registerCourse(Scanner scanner) {
        CourseRegistration reg = new CourseRegistration(null, null, null, null); // Khởi tạo với giá trị mặc định
        reg.inputData(scanner); // Sử dụng inputData để nhập thông tin
        Student student = students.stream().filter(s -> s.getStudentId().equals(reg.getStudentId())).findFirst().orElse(null);
        Course course = courses.stream().filter(c -> c.getCourseId().equals(reg.getCourseId())).findFirst().orElse(null);
        if (student != null && course != null) {
            registrations.add(reg);
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Sinh viên hoặc khóa học không tồn tại!");
        }
    }

    public void cancelRegistration(Scanner scanner) {
        String studentId = Validator.validateID("Nhập mã sinh viên (SVxxx): ", scanner, "student");
        String courseId = Validator.validateID("Nhập mã khóa học (Cxxxx): ", scanner, "course");
        CourseRegistration toCancel = registrations.stream()
                .filter(r -> r.getStudentId().equals(studentId) && r.getCourseId().equals(courseId))
                .findFirst().orElse(null);
        if (toCancel != null && "PENDING".equals(toCancel.getStatus())) {
            registrations.remove(toCancel);
            System.out.println("Hủy đăng ký thành công!");
        } else {
            System.out.println("Không thể hủy vì trạng thái không phải PENDING hoặc không tìm thấy!");
        }
    }

    public void approveRegistration(Scanner scanner) {
        String studentId = Validator.validateID("Nhập mã sinh viên (SVxxx): ", scanner, "student");
        String courseId = Validator.validateID("Nhập mã khóa học (Cxxxx): ", scanner, "course");
        CourseRegistration toApprove = registrations.stream()
                .filter(r -> r.getStudentId().equals(studentId) && r.getCourseId().equals(courseId))
                .findFirst().orElse(null);
        if (toApprove != null && "PENDING".equals(toApprove.getStatus())) {
            toApprove.setStatus("ENROLLED");
            System.out.println("Duyệt thành công!");
        } else {
            System.out.println("Không thể duyệt vì trạng thái không phải PENDING hoặc không tìm thấy!");
        }
    }

    public void listRegistrationsByCourse(Scanner scanner) {
        String courseId = Validator.validateID("Nhập mã khóa học (Cxxxx): ", scanner, "course");
        registrations.stream()
                .filter(r -> r.getCourseId().equals(courseId))
                .forEach(CourseRegistration::display); // Sử dụng display()
    }
}