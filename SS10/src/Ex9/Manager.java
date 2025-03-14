package Ex9;


public class Manager extends Employee {
    private double bonus;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String toString() {
        return "Tên nhân viên: " + getName() + " - Mã nhân viên: " + getId() + " - Lương nhân viên: " + getSalary() + " - Tiền thưởng: " + bonus;
    }
}