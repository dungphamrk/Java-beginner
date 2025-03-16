package Ex8;

public class GasCar extends Car implements  Refuelable{
    public GasCar(String model,int year,double price) {
        this.model=model;
        this.year=year;
        this.price=price;
    }

    public GasCar() {
    }

    @Override
    String start() {
        return  String.format("%s (Năm SX: %d, Giá: %.2f) đã khởi động với tiếng động cơ", model, year, price);
    }

    @Override
    String stop() {
        return  String.format("%s (Năm SX: %d, Giá: %.2f) đã dừng và động cơ tắt", model, year, price);
    }

    @Override
    public String refuel() {
        return  String.format("%s (Năm SX: %d, Giá: %.2f)  đang được đổ xăng...", model, year, price);
    }
}
