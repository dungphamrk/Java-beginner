package Ex10;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2* (width + height);
    }

    @Override
    public String toString() {
        return "Chiều rộng HCN: " +this.width+ " - Chiều dài HCN: " +this.height+ " - Diện tích HCN: " + calculateArea() + " - Chu vi HCN: " + calculatePerimeter();
    }
}