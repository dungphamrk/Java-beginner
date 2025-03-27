package business;

import entity.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderBusiness implements IOrderBusiness{
    public static List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(Scanner scanner) {
        Order newOrder = new Order();
        newOrder.inputData(scanner);
        orders.add(newOrder);
    }

    @Override
    public void displayOrders() {
        orders.forEach(System.out::println);
    }

    @Override
    public void updateOrderStatus(Scanner scanner) {
        System.out.println("Nhập mã đơn hàng muốn cập nhập");
        int idUpdate= Integer.parseInt(scanner.nextLine());
        for(Order order:orders){
            if(order.getId()==idUpdate){
                order.setStatus(Boolean.parseBoolean(scanner.nextLine()));
            }
        }
    }

    @Override
    public List<Order> getOrderOverdue() {
        LocalDate now = LocalDate.now();
        return orders.stream()
                .filter(order -> order.getOrderDate().isBefore(now)&& !order.getStatus())
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrderDelivired() {
        LocalDate now = LocalDate.now();
        return orders.stream()
                .filter(order -> order.getOrderDate().isBefore(now)&& order.getStatus())
                .collect(Collectors.toList());
    }
}
