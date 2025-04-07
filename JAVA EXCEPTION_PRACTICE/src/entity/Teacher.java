package entity;

import util.Validator;

import java.util.Scanner;

public class Teacher extends Person {
    static int autoId = 1000;
    int teacherId;
    String subject;

    public  Teacher() {};
    public Teacher(String name, int age, String phone, String address, String email, String sex, int teacherId, String subject) {
        super(name, age, phone, address, email, sex);
        this.teacherId = teacherId;
        this.subject = subject;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Teacher.autoId = autoId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void inputData(Scanner scanner) {
        super.inputData(scanner);
        this.teacherId = autoId++;
        subject = Validator.validateString("Nhập chuyên môn: ", scanner, 1, 100);
    }

    public void display() {
        super.display();
        System.out.println("Mã GV: " + teacherId + ", Chuyên môn: " + subject);
    }
}
