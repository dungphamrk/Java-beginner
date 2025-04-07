package entity;

import util.Validator;

import java.util.Scanner;

public class Student extends Person {
    String studentId;
    double gpa;
    public Student() {
    }

    public Student(String name, int age, String phone, String address, String email, String sex, String studentId, double gpa) {
        super(name, age, phone, address, email, sex);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public void inputData(Scanner scanner) {
        super.inputData(scanner);
        studentId = Validator.validateString("Nhập mã SV : ", scanner, 5, 5);
        gpa = Validator.validateDouble("Nhập GPA: ", scanner, 0);
    }

    public void display() {
        super.display();
        System.out.println("Mã SV: " + studentId + ", GPA: " + gpa);
    }
}