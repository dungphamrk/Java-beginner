package Ex6;

public class Lion  extends Animal{
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println("Roar");
    }
    @Override
    public void move() {
        System.out.println("The lion is running");
    }

}
