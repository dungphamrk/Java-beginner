package Ex9;

class Car extends Vehicle {
    @Override
    void move() {
        System.out.println("Car di chuyển trên mặt đất.");
    }

    @Override
    void sound() {
        System.out.println("Car phát ra âm thanh: Vroom");
    }
}

