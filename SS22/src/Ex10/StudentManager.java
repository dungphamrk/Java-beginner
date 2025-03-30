package Ex10;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    List<Student> students = new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Đối tượng đã được ghi vào file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Student> students = (List<Student>) ois.readObject();
            students.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Student findTopStudent() {
        return students.stream().max((s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa())).orElse(null);
    }

    public List<Student> searchByMajor(String major) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }
        return result;
    }

    public double calculateAverageGpa() {
        return students.stream().mapToDouble(Student::getGpa)
                .average().orElse(0.0);
    }
}
