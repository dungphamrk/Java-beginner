package Ex10;

public class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calculateArea() {
        return 0.0;
    }

    public double calculatePerimeter() {
        return 0.0;
    }
    public String toString() {
        return "Tên của hình: " + this.name + " - Diện tích: " + calculateArea() + "Chu vi: " + calculatePerimeter();
    }
}