package Ex3;

public abstract class Vehicle {
    String name;
    int speed;
    abstract void displayInfo();

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void start(){
        System.out.println("Vehicle is starting...");
    }

}
