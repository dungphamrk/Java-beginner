package Ex3;

import java.util.Optional;

public class User {
    private String name;
    private Optional<String> phoneNumber;

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Optional<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = Optional.ofNullable(phoneNumber);
    }
    public void printInfo() {
        System.out.println("Tên: " + getName() + " " + "SDT: " + phoneNumber.orElse("Không có"));
    }
}
