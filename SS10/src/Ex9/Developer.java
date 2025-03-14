package Ex9;

public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String toString() {
        return "Tên nhân viên: " + getName() + " - Mã nhân viên: " + getId() + " - Lương nhân viên: " + getSalary() + " - Ngôn ngữ lập trình: " +this.programmingLanguage;
    }
}