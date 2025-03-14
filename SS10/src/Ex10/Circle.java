package Ex10;

public class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double calculatePerimeter() {
        return  2 * Math.PI * this.radius;
    }
    @Override
    public String toString() {
        return "Bán kính hình tròn: " +this.radius+ " - Diện tích hình tròn: " + calculateArea() + " - Chu vi hình tròn: " + calculatePerimeter();
    }
}