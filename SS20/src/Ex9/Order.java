package Ex9;

import java.time.LocalDate;
import java.util.Optional;

public class Order {
    private int  id;
    private String customerName;
    private LocalDate createdDate;
    private Optional<LocalDate> deliveryDate;
    public Order() {
    }

    public Order(int id, String customerName, LocalDate createdDate, LocalDate deliveryDate) {
        this.id = id;
        this.customerName = customerName;
        this.createdDate = createdDate;
        this.deliveryDate = Optional.ofNullable(deliveryDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Optional<LocalDate> getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = Optional.ofNullable(deliveryDate);
    }

    @Override
    public String toString() {
        return "ID: "+id+"  | KH: "+customerName+"     | Đặt: "+createdDate+" | Giao: "+ (deliveryDate.map(LocalDate::toString).orElse("Chưa giao"));
    }

}
