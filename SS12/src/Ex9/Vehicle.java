package Ex9;

public abstract class Vehicle {
    abstract void move();
    abstract void sound();
    public void move(int time, int speed) {
        int distance = time * speed;
        System.out.println("Khoảng cách di chuyển: " + distance + " km");
    }
}
