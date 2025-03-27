package business;

import entity.Order;

import java.util.List;
import java.util.Scanner;

import static business.OrderBusiness.orders;

public interface IOrderBusiness {
    void addOrder(Scanner scanner);
    void displayOrders();
    void updateOrderStatus(Scanner scanner);
    List<Order> getOrderOverdue();
    List<Order> getOrderDelivired();
    default double getTotalRevenue(){
        return orders.stream().
                filter(Order::getStatus)
                .map(Order::getTotalAmount)
                .reduce(0.0, Double::sum);
    }
}
