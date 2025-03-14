package Ex9;

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee employee = new Employee("AA", 1, 1111);
        Manager manager = new Manager("bb",2,23213,2311);
        Developer developer = new Developer("cc",3,1213,"Java,C#");

        System.out.println("Lương của nhân viên: "+employee.getSalary());
        System.out.println("Lương của quản lí: "+manager.getSalary());
        System.out.println("Lương của lập trình viên: "+developer.getSalary());

        System.out.println("Thông tin chi tiết về nhân viên: "+employee.toString());
        System.out.println("Thông tin chi tiết về quản lí: "+developer.toString());
        System.out.println("Thông tin chi tiết về lập trình viên: "+manager.toString());

        employee.increaseSalary(1111);
        System.out.println("Lương của nhân viên sau khi tăng lương: "+employee.toString());
        manager.increaseSalary(2222);
        System.out.println("Lương của quản lí sau khi tăng lương: "+manager.toString());
        developer.increaseSalary(3333);
        System.out.println("Lương của lập trình viên sau khi tăng lương: "+developer.toString());
    }
}
