package Ex4;

public class Main {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2(thread1);
        Thread3 thread3 = new Thread3(thread1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}