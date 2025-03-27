package entity;

import java.util.Optional;
import java.util.Scanner;

public class Customer implements IApp {
    private static int countID=0;
    private int id;
    private String name;
    private Optional<String> email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Optional.ofNullable(email);
    }
    private int initialID(){
        return countID++;
    }

    public Customer( String name, Optional<String> email) {
        this.id = initialID();
        this.name = name;
        this.email = email;
    }

    public Customer() {
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên khách hàng");
        name=scanner.nextLine();
        System.out.println("Nhập email của khách hàng");
        email =Optional.of(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email.orElse("Không có Email") +
                '}';
    }
}
