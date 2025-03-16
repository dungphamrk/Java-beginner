package Ex4;

public class Shape {
    public double area(){
        return 0;
    }
    public double area(double radius){
        return Math.PI * radius * radius;
    }
    public double area(double width,double height){
        return width * height;
    }
}