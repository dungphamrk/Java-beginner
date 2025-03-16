package Ex5;

public class Circle implements Colorable {
    double radius;
    String color ;
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return color;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
}
