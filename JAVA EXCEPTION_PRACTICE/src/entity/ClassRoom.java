package entity;
import util.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassRoom implements IApp {
    static int autoId = 1;
    int classroomId;
    String classRoomName;
    String courseId;
    int teacherId;
    List<Student> listStudents = new ArrayList<>();
    LocalDate created;
    String status;

    public ClassRoom( String classRoomName, String courseId, int teacherId, List<Student> listStudents, LocalDate created, String status) {
        this.classroomId = autoId++;
        this.classRoomName = classRoomName;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.listStudents = listStudents;
        this.created = created;
        this.status = status;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        ClassRoom.autoId = autoId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.classroomId = autoId++;
        classRoomName = Validator.validateString("Nhập tên lớp học: ", scanner, 15, 50);
        courseId = Validator.validateString("Nhập mã khóa học: ", scanner, 5, 10);
        teacherId = Validator.validateInt("Nhập mã giảng viên: ", scanner, 1);
        created = LocalDate.now();
        status = Validator.validateStatusEnum("Chọn trạng thái lớp học:", scanner);
    }

    public void display() {
        System.out.println("Mã lớp: " + classroomId + ", Tên lớp: " + classRoomName + ", Mã KH: " + courseId + ", GV: " + teacherId + ", Ngày tạo: " + created + ", Trạng thái: " + status);
    }
}
