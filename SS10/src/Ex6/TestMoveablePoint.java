package Ex6;

public class TestMoveablePoint {
    public static void main(String[] args) {
        Point p= new Point();
        MoveablePoint mp=new MoveablePoint();
        mp.setxSpeed(2);
        mp.setySpeed(3);
        mp.setX(10);
        mp.setY(7);
        System.out.println(mp);
        mp.move();
        System.out.println(mp);
    }
}
