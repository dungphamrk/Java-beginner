package Ex5;

public class Square implements Colorable {
    double width;
    double height;
    String color ;
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return color;
    }

    public Square(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }
}
