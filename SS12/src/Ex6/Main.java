package Ex6;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[100];

        employees[0] = new FullTimeEmployee("aa", 312, 123000, 12300);
        employees[1] = new PartTimeEmployee("aaa", 21232, 230, 123); // 20$/h * 80h
        employees[2] = new Intern("aaaaaaa", 230, 1023);

        for (Employee emp : employees) {
            emp.showInfo();
        }
    }
}
