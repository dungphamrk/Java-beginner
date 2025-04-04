package Ex3;

public class Main {
    public static void main(String[] args) {
        Car sportsCar = new CarBuilder()
                .setEngine("V8")
                .setSeats(2)
                .setColor("Red")
                .build();
        Car familyCar = new CarBuilder()
                .setEngine("V6")
                .setSeats(7)
                .setColor("Blue")
                .build();
        Car defaultCar = new CarBuilder()
                .build();
        System.out.println("Xe thể thao: " + sportsCar);
        System.out.println("Xe gia đình: " + familyCar);
        System.out.println("Xe bình thường: " + defaultCar);
    }
}