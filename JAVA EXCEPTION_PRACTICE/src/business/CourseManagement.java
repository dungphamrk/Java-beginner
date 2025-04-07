package business;

import entity.Course;
import util.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CourseManagement {
    private List<Course> courses;

    public CourseManagement(List<Course> courses) {
        this.courses = courses;
    }

    public void listCourses() {
        courses.stream()
                .sorted(Comparator.comparing(Course::getCourseName))
                .forEach(Course::display); // Sử dụng phương thức display của Course
    }

    public void addCourse(Scanner scanner) {
        Course course = new Course(null, null, false); // Khởi tạo với giá trị mặc định
        course.inputData(scanner);
        courses.add(course);
        System.out.println("Thêm thành công!");
    }

    public void updateCourse(Scanner scanner) {
        String updateId = Validator.validateID("Nhập mã khóa học cần cập nhật (Cxxxx): ", scanner, "course");
        Course course = courses.stream().filter(c -> c.getCourseId().equals(updateId)).findFirst().orElse(null);
        if (course != null) {
            course.setCourseName(Validator.validateString("Nhập tên mới: ", scanner, 20, 100));
            course.setStatus(Validator.validateBoolean("Nhập trạng thái mới (true/false): ", scanner));
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy khóa học!");
        }
    }

    public void deleteCourse(Scanner scanner) {
        String deleteId = Validator.validateID("Nhập mã khóa học cần xóa (Cxxxx): ", scanner, "course");
        Course toDelete = courses.stream().filter(c -> c.getCourseId().equals(deleteId)).findFirst().orElse(null);
        if (toDelete != null) {
            // Kiểm tra xem khóa học có lớp học nào không (giả sử cần thêm logic kiểm tra quan hệ)
            courses.remove(toDelete);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không thể xóa vì khóa học không tồn tại!");
        }
    }
}