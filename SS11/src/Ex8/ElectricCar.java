package Ex8;

public class ElectricCar extends Car  implements Refuelable{
    public ElectricCar(String model,int year,double price) {
        this.model=model;
        this.year=year;
        this.price=price;
    }

    public ElectricCar() {
    }


    @Override
    String start() {
        return  String.format("%s (Năm SX: %d, Giá: %.2f)  đã khởi động không tiếng ồn", model, year, price);
    }

    @Override
    String stop() {
        return  String.format("%s (Năm SX: %d, Giá: %.2f) đã dừng và ngắt kết nối động cơ", model, year, price);
    }

    @Override
    public String refuel() {
        return  String.format("%s (Năm SX: %d, Giá: %.2f) đang sạc điện…", model, year, price);
    }
}
