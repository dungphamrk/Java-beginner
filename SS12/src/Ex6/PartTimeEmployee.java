package Ex6;

public class PartTimeEmployee extends  Employee {
    private int workingHours;

    public PartTimeEmployee(String name, int age, double basicSalary, int workingHours) {
        super(name, age, basicSalary);
        this.workingHours = workingHours;
    }

    @Override
    public double calculateSalary() {
        return basicSalary * workingHours;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Loại: Nhân viên Part-time");
        System.out.println("Số giờ làm việc: " + workingHours + " giờ");
        System.out.println("Tổng lương: $" + calculateSalary());
    }
}
