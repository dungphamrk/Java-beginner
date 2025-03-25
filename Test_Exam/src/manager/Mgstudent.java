package manager;
import entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static presentation.StudentManagement.students;
public class Mgstudent {
    public static void displayStudents(){
        System.out.println("Danh sách thông tin của các học sinh là: ");
        for(Student student:students.values()){
            student.toString();
        }
    }
    public static void addStudent(Scanner scanner){
        Student newStudent = new Student();
        newStudent.inputData(scanner);
        students.put(newStudent.getStudentID(), newStudent);
    }
    public static void delStudent(Scanner scanner){
        System.out.println("Nhập mã sinh viên cần xóa");
        String delId=scanner.nextLine();
        if(students.containsKey(delId)){
            students.remove(delId);
        }else{
            System.out.println("Sinh viên có id đó không tồn tại");
        }
    }
    public static void printAVGScore(){
        int count=0;
        double avgAllStudent=0;
        for(Student  student : students.values()){
            count++;
            avgAllStudent+=student.getAvgScore();
        }
        System.out.println("Điểm trung bình của tất cả sinh viên là: " + avgAllStudent/count);
    }
    public static void maxAvgScoreOfAllStudent(){
        List<Student> listStudent = new ArrayList<Student>(students.values());
        Student highestScoreOfStudent = listStudent.get(0);
        for(Student student : listStudent){
            if(student.getAvgScore()>highestScoreOfStudent.getAvgScore()){
                highestScoreOfStudent = student;
            }
        }
        System.out.println("Học sinh có điểm cao nhất là: "+ highestScoreOfStudent.toString());
    }
   public static  void minAgeOfAllStudent(){
       List<Student> listStudent = new ArrayList<Student>(students.values());
       Student youngestStudent = listStudent.get(0);
       for(Student student : listStudent){
           if(student.getAge()<youngestStudent.getAge()){
               youngestStudent = student;
           }
       }
       System.out.println("Học sinh có tuổi nhỏ nhất là: " + youngestStudent.toString());
   }

}
