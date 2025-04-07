package entity;

import util.Validator;

import java.util.Scanner;

class Person implements IApp {
    String name;
    int age;
    String address;
    String phone;
    String email;
    String sex;

    public Person(){};
    public Person(String name, int age, String phone, String address, String email, String sex) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.sex = sex;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void inputData(Scanner scanner) {
        name = Validator.validateString("Nhập tên: ", scanner, 1, 150);
        age = Validator.validateInt("Nhập tuổi: ", scanner, 18);
        address = Validator.validateString("Nhập địa chỉ: ", scanner, 1, 200);
        phone = Validator.validatePhone("Nhập SĐT: ", scanner);
        email = Validator.validateString("Nhập email: ", scanner, 5, 100); // add email regex if needed
        sex = Validator.validateString("Nhập giới tính (MALE/FEMALE/OTHER): ", scanner, 4, 10);
    }

    public void display() {
        System.out.println("Tên: " + name + ", Tuổi: " + age + ", Địa chỉ: " + address + ", SĐT: " + phone + ", Email: " + email + ", Giới tính: " + sex);
    }


}