package Ex9;

class Bike extends Vehicle {
    @Override
    void move() {
        System.out.println("Bike di chuyển với tốc độ chậm.");
    }

    @Override
    void sound() {
        System.out.println("Bike phát ra âm thanh: Ring Ring");
    }
}
