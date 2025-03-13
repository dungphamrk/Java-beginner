package Ex5;

public class TestShape {
    public static void main(String[] args) {
        Circle  circle = new Circle();
        Cylinder  cylinder = new Cylinder();
        circle.setRadius(1.2);
        cylinder.setRadius(1);
        cylinder.setHeight(10);
        System.out.println("Diện tích của hình tròn là: "+ circle.getArea());
        System.out.println("Thể tích của hình trụ là: "+ cylinder.getVolume());
        circle.setRadius(99);
        cylinder.setRadius(2);
        cylinder.setHeight(3);
        System.out.println("Diện tích của hình tròn sau khi thay đổi là là: "+ circle.getArea());
        System.out.println("Thể tích của hình trụ sau khi thay đổi là: "+ cylinder.getVolume());
    }
}
