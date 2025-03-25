package entity;

import java.util.Scanner;

public class Student {
    private String studentID;
    private String name;
    private int age;
    private float avgScore;

    public Student() {
    }

    public Student(String studentID, String name, int age, float avgScore) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.avgScore = avgScore;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public void inputData(Scanner scanner) {
        studentID = inputStudentId(scanner);
        name=inputName(scanner);
        age=inputAge(scanner);
        avgScore=inputAvgScore(scanner);
    }
    public String inputStudentId(Scanner scanner) {
        System.out.println("Nhập mã sinh viên");
        return scanner.nextLine();
    }
    public String inputName(Scanner scanner) {
        System.out.println("Nhập tên sinh viên");
        return scanner.nextLine();
    }
    public int inputAge(Scanner scanner) {
        System.out.println("Nhập tuổi của sinh viên");
        return scanner.nextInt();
    }
    public float inputAvgScore(Scanner scanner) {
        System.out.println("Nhập điểm trung bình của sinh viên đó");
        return scanner.nextFloat();
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", name=" + name + ", age=" + age + ", avgScore=" + avgScore + '}';
    }
}
