package Ex10;

public class TestShape {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle("Hình tròn",4),
                new Rectangle("Hình chữ nhật",2,1),
                new Triangle("Tam giác",3,2,5),
        };
        System.out.println("Thông tin chi tiết của từng hình : ");
        for (Shape shape : shapes) {
            System.out.println(shape.getName() + ":");
            System.out.println("Diện tích: " +shape.calculateArea());
            System.out.println("Chu vi: "+shape.calculatePerimeter());
            System.out.println("----------------------------");
        }

    }
}
