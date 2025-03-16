package Ex8;

public abstract class Car {
    String model;
    int year;
    double price;
    abstract String start();
    abstract String stop();

    public abstract String refuel();
}
