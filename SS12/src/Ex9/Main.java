package Ex9;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle bus = new Bus(4323);
        Vehicle airplane = new Airplane(1023000);

        car.move();
        car.sound();
        car.move(123, 60);

        System.out.println();

        bike.move();
        bike.sound();
        bike.move(123, 20);

        System.out.println();

        bus.move();
        bus.sound();
        bus.move(32, 50);

        System.out.println();

        airplane.move();
        airplane.sound();
        airplane.move(111, 800);
    }
}


