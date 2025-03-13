package Ex3;

public class TestCar {
    public static void main(String[] args) {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("BMW");
        System.out.println(car.getMake());
        System.out.println(car.getModel());
        car.setYear(5000);
    }
}
