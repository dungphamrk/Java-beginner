package Ex4;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(1);
        Shape rectangle = new Rectangle(2.3, 6);
        Shape shape = new Shape();
        System.out.println("Diện tích hình tròn : " + circle.area());
        System.out.println("Diện tích hình chữ nhật : " + rectangle.area());
        System.out.println("Diện tích hình tròn : " + shape.area(2));
        System.out.println("Diện tích hình chữ nhật : " + shape.area(123, 11));
    }
}