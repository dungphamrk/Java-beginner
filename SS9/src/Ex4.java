public class Ex4 {
    public static class Circle {
        public int radius ;
        public Circle(int radius) {
            this.radius = radius==0?1:radius;
        }
        public Circle(){
            this.radius = 1;
        }
        public double  getArea() {
            return radius * radius * Math.PI;
        }
        public double getCircumference(){
            return 2 * radius * Math.PI;
        }
        public void display(){
            System.out.println("Bán kính: " +radius);
            System.out.println("Diện tích: "+getArea());
            System.out.println("Chu vi: "+getCircumference());
        }
    }
    public static void main(String[] args) {
        Circle a=new Circle();
        Circle b=new Circle(5);
        a.display();
        b.display();
    }
}
