public class Ex3 {
    public static class Rectangle {
        private int width;
        private int height;
        public Rectangle(int width, int height) {
            this.width = width ;
            this.height = height ;
        }

        public Rectangle() {
            this.height=1;
            this.width=1;
        }

        public int  getArea(){
            return width*height;
        }
        public int getPerimeter(){
            return  (width+height)*2;
        }
        public void display(){
            System.out.println("Chiều dài: "+ width);
            System.out.println("Chiều rộng: "+height);
            System.out.println("Diện tích: "+getArea());
            System.out.println("Chu vi: "+getPerimeter());
        }
    }
    public static void main(String[] args) {
        Rectangle a = new Rectangle(2,2);
        Rectangle b= new Rectangle();
        b.display();
        a.display();
    }
}
