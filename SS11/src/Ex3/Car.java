package Ex3;

public class Car extends Vehicle {

    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    void displayInfo() {
        System.out.println("đây là xe hơi có tên "+ name + "Tốc độ"+ speed);
    }
}
