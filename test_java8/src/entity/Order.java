package entity;

import java.time.LocalDate;
import java.util.Scanner;

import static business.CustomerBusiness.listCustomer;

public class Order implements  IApp {
    private static int countID=0;
    private int id ;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private Boolean status;

    public int getId() {
        return id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    private int initialID(){
        return countID++;
    }

    public Order(Customer customer, LocalDate orderDate, double totalAmount, Boolean status) {
        this.id = initialID();
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Order() {
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập id khách hàng muốn đặt hàng");
        customer= listCustomer.stream()
                .filter(customer1 ->  customer1.getId()==Integer.parseInt(scanner.nextLine()))
                .findFirst().get();
        System.out.println("Nhập ngày đặt hàng");
        orderDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Nhập tổng tiền :");
        totalAmount =Double.parseDouble(scanner.nextLine());
        status = false;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
    }
}
