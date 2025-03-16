package Ex9;

class Bus extends Vehicle {
    int seats;
    Bus(int seats) {
        this.seats = seats;
    }
    @Override
    void move() {
        System.out.println("Bus di chuyển trên mặt đất.");
    }
    @Override
    void sound() {
        System.out.println("Bus phát ra âm thanh: Honk");
    }
}