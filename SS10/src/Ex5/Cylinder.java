package Ex5;

public class Cylinder extends  Circle {
    double height;
    public double getVolume(){
        return Math.PI*height*radius*radius;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height = height;
    }


}
