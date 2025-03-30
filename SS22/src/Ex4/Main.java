package Ex4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Pham Quang Dung", 20, 22));
        File writeFile = new File("student.dat");
        try (FileOutputStream fos = new FileOutputStream(writeFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(students);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File readFile = new File("student.dat");
        try (FileInputStream fis = new FileInputStream(readFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Student> readStudents = (List<Student>) ois.readObject();
            readStudents.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}