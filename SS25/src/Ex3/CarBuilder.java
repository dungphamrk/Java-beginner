package Ex3;

public class CarBuilder {
    private String engine;
    private int seats;
    private String color;

    public CarBuilder() {
        this.engine = "Unknown";
        this.seats = 4;
        this.color = "White";
    }

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
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

    public Car build() {
        return new Car(this);
    }
}