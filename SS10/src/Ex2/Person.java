package Ex2;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private String address;
    private boolean sex;

    public Person() {
    }

    public Person(String name, int age, String address, boolean sex) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào tên:");
        this.name = scanner.nextLine();
        System.out.println("Nhập vào tuổi:");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào địa chỉ:");
        this.address = scanner.nextLine();
        System.out.println("Nhập vào giới tính:");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        System.out.printf("Tên: %s - Tuổi: %d - Địa chỉ: %s - Giới tính: %b\n",
                this.name, this.age, this.address, this.sex);
    }
}