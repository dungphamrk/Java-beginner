package Ex1;

public class Main {
    public static void main(String[] args) {
        MyThread m1= new MyThread();
        MyThread m2= new MyThread();
        m1.setName("m1");
        m2.setName("m2");
        m1.start();
        m2.start();
    }
}
