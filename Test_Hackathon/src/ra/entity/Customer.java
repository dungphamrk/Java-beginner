package ra.entity;

import java.util.Scanner;

import static ra.validate.Validator.*;

public class Customer implements IApp {
    String customerId;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String address;
    String dateOfBirth;
    boolean gender;
    String customerType;

    public Customer(String customerId, String lastName, String firstName, String email, String phoneNumber, String address, String dateOfBirth, boolean gender, String customerType) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.customerType = customerType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Customer() {
    }

    @Override
    public void inputData(Scanner scanner) {
        customerId=validateCustomerId(scanner,"Nhập vào mã id của khách hàng");
        lastName=validateString(scanner,"Nhập vào tên của khách hàng",50,0);
        firstName=validateString(scanner,"Nhập vào họ của khách hàng",30,0);
        dateOfBirth=validateDate(scanner,"Nhập vào ngày sinh của khách hàng");
        email=validateEmail(scanner,"Nhập vào email của khách hàng");
        address =validateString(scanner,"Nhập vào địa chỉ của khách hàng",255,0);
        phoneNumber=validateString(scanner,"Nhập vào số điện thoại của khách hàng",10,0);
        gender=validateGender(scanner,"Nhập vào giới tính của khách hàng");
        customerType = validateString(scanner,"Nhập vào loại khách hàng",100,0);
    }

    public void displayData() {
        System.out.println(
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", customerType='" + customerType + '\''
                );
    }
}
