package ra.entity;

import ra.validate.StudentValidate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements IApp {
    private String studentId;
    private String studentName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private String email;
    private String major;
    private String className;
    private float gpa;
    private byte status;
    private static List<Student> students = new ArrayList<>();
    private static int studentCounter = 1;

    public Student() {
        this.studentId = "SV" + String.format("%05d", studentCounter++);
        this.status = 1; // Mặc định là đang theo học
    }

    public Student(String studentName, String birthday, String phoneNumber, boolean sex, String email, String major, String className, float gpa) {
        this();
        this.studentName = studentName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.email = email;
        this.major = major;
        this.className = className;
        this.gpa = gpa;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        this.studentName = StudentValidate.inputStudentName(scanner);
        this.birthday = StudentValidate.inputBirthday(scanner);
        this.phoneNumber = StudentValidate.inputPhoneNumber(scanner);
        this.sex = StudentValidate.inputSex(scanner);
        this.email = StudentValidate.inputEmail(scanner);
        this.major = StudentValidate.inputMajor(scanner);
        this.className = StudentValidate.inputClassName(scanner);
        this.gpa = StudentValidate.inputGpa(scanner);
        students.add(this);
    }

    @Override
    public void displayData() {
        int age = calculateAge();
        String statusStr = status == 1 ? "Đang theo học" : status == 2 ? "Bảo lưu" : "Đã nghỉ học";
        System.out.printf("Mã SV: %s | Tên: %s | Tuổi: %d | Giới tính: %s | SĐT: %s | Lớp: %s | Trạng thái: %s\n",
                studentId, studentName, age, sex ? "Nam" : "Nữ", phoneNumber, className, statusStr);
    }

    private int calculateAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(birthday, formatter);
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public static List<Student> getStudents() {
        return students;
    }
}