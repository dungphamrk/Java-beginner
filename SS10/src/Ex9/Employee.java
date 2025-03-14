package Ex9;

public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double amount) {
        if (amount > 0) {
            this.salary += amount;
            System.out.println("Tăng lương thành công");
        } else {
            System.out.println("Số tiền đưa vào không hợp lệ");
        }
    }

    public String toString() {
        return "Tên nhân viên: " + this.name + " - Mã nhân viên: " + this.id + " - Lương nhân viên: " + this.salary;
    }
}
