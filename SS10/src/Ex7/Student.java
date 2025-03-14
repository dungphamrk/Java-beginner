package Ex7;

public class Student {
    String name;
    String id;
    double gpa;

    public Student(String name, String id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public void getDetails(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("GPA: " + gpa);
    }
}
