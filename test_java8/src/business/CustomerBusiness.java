package business;

import entity.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomerBusiness {
    public static List<Customer> listCustomer = new ArrayList<>();
    public static void addCustomer(Scanner scanner){
        Customer newCustomer = new Customer();
        newCustomer.inputData(scanner);
        listCustomer.add(newCustomer);
    }
    public static void displayCustomers(){
        listCustomer.forEach(System.out::println);
    }
}
