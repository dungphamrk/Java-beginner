package Ex3;

public class Bike extends  Vehicle {

    public Bike(String name, int speed) {
        super(name, speed);
    }

    @Override
    void displayInfo() {
        System.out.println("Đây là xe đạp có tên "+ name+"Vói tốc độ"+ speed);
    }
}
