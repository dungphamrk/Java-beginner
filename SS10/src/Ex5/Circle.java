package Ex5;

public class Circle {
    double radius;
    public double getArea(){
        return  radius * radius*Math.PI;
    }
    double getRadius(){
        return radius;
    }
    void setRadius(double radius){
        this.radius = radius;
    }

}
