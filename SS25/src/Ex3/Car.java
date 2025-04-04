package Ex3;

public class Car {
    private String engine;
    private int seats;
    private String color;

    Car(CarBuilder builder) {
        this.engine = builder.getEngine();
        this.seats = builder.getSeats();
        this.color = builder.getColor();
    }

    public String getEngine() {
        return engine;
    }

    public int getSeats() {
        return seats;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", seats=" + seats + ", color=" + color + "]";
    }
}