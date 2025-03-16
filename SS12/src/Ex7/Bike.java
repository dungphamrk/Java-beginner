package Ex7;

public class Bike extends Vehicle {
    @Override
    public String move() {
        return "Di chuyển";
    }

    @Override
    public String sound() {
        return "Ring Ring";
    }
}
