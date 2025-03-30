package Ex10;

import java.util.List;

class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student(1, "Nguyễn Văn A", 8.5, "CNTT"));
        manager.addStudent(new Student(2, "Trần Thị B", 7.8, "Kinh tế"));
        manager.addStudent(new Student(3, "Lê Văn C", 9.0, "CNTT"));
        manager.addStudent(new Student(4, "Phạm Thị D", 8.0, "Kinh tế"));

        manager.saveToFile("students.dat");

        manager.loadFromFile("students.dat");

        Student topStudent = manager.findTopStudent();
        System.out.println("\nSinh viên có GPA cao nhất: " + topStudent);

        List<Student> cnttStudents = manager.searchByMajor("CNTT");
        System.out.println("\nSinh viên ngành CNTT:");
        cnttStudents.forEach(System.out::println);

        double avgGpa = manager.calculateAverageGpa();
        System.out.println("\nĐiểm GPA trung bình: " + avgGpa);
    }
}
