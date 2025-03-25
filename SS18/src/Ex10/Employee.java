package Ex10;

public class Employee {
    private static int countId = 0;
    private int id;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.id = initialId() ;
        this.name = name;
        this.salary = salary;
    }
    private int initialId(){
        return ++countId;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Mã nhân viên: " +id+ " - Tên nhân viên: " +name+ " - Lương nhân viên: " +salary;
    }
}
