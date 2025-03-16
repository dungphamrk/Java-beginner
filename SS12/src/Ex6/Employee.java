package Ex6;

public class Employee {
    protected String name;
    protected int age;
    protected double basicSalary;
    public Employee(String name, int age, double basicSalary) {
        this.name = name;
        this.age = age;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary(){
        return this.basicSalary;
    }

    public void showInfo(){
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Lương cơ bản: " + basicSalary);
    }

}