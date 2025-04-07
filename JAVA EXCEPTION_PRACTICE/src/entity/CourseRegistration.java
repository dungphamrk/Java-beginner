package entity;

import util.Validator;

import java.time.LocalDate;
import java.util.Scanner;

public class CourseRegistration implements IApp {
    static int autoId = 1;
    int crid;
    String studentId;
    String courseId;
    String status;
    LocalDate regDate;

    public CourseRegistration(String studentId, String courseId, String status, LocalDate regDate) {
        this.crid = autoId++;
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
        this.regDate = regDate;
    }



    public int getCrid() {
        return crid;
    }

    public void setCrid(int crid) {
        this.crid = crid;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        CourseRegistration.autoId = autoId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.crid = autoId++;
        studentId = Validator.validateString("Nhập mã SV: ", scanner, 5, 10);
        courseId = Validator.validateString("Nhập mã khóa học: ", scanner, 5, 10);
        regDate = LocalDate.now();
        status = Validator.validateStatusEnum("Chọn trạng thái đăng ký:", scanner);
    }

    public void display() {
        System.out.println("Mã ĐK: " + crid + ", SV: " + studentId + ", Khóa học: " + courseId + ", Ngày: " + regDate + ", Trạng thái: " + status);
    }
}
