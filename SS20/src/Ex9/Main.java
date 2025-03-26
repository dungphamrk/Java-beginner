package Ex9;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Quý", LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 25)),
                new Order(2, "Lan", LocalDate.of(2025, 3, 21), null),
                new Order(3, "Minh", LocalDate.of(2025, 3, 22), LocalDate.of(2025, 3, 23)),
                new Order(4, "Huyền", LocalDate.of(2025, 3, 23), null),
                new Order(5, "Việt", LocalDate.of(2025, 3, 23), LocalDate.of(2025, 3, 30))
        );

        System.out.println("== Danh sách đơn hàng đã giao ==");
        orders.stream().filter(order -> order.getDeliveryDate().isPresent()).forEach(System.out::println);
        System.out.println("== Danh sách đơn hàng chưa giao ==");
        orders.stream().filter(order -> order.getDeliveryDate().isEmpty()).forEach(System.out::println);
        System.out.println("== Số đơn hàng đã giao từ ngày 2025-03-17 đến 2025-03-23 ==");
        LocalDate startDate = LocalDate.of(2025, 3, 17);
        LocalDate endDate = LocalDate.of(2025, 3, 23);

        orders.stream()
                .filter(order -> order.getDeliveryDate()
                        .filter(deliveryDate -> !deliveryDate.isBefore(startDate) && !deliveryDate.isAfter(endDate))
                        .isPresent())
                .forEach(System.out::println);
    }
}
