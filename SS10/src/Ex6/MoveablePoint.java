package Ex6;

public class MoveablePoint extends  Point {
    double xSpeed;
    double ySpeed;
    public double getxSpeed() {
        return xSpeed;
    }
    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }
    public double getySpeed() {
        return ySpeed;
    }
    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void  move(){
        x=x+xSpeed;
        y=y+ySpeed;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "y=" + y +
                ", x=" + x +
                ", ySpeed=" + ySpeed +
                ", xSpeed=" + xSpeed +
                '}';
    }
}
