package Ex4;

public class TV implements Electronic {

    @Override
    public void turnOff() {
        System.out.println("Turning off TV ...");
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on TV ...");
    }
}
