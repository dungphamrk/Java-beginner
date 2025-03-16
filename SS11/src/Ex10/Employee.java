package Ex10;

public abstract class Employee {
    String name ;
    double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public abstract String work();
    public abstract String takeVacation();

    public String attendMeeting() {
        return null;
    }
}
