package Ex4;

public class Radio implements  Electronic {

    @Override
    public void turnOff() {
        System.out.println("Turning off Radio ...");
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on Radio ...");
    }
}
