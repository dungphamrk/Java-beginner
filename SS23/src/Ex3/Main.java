package Ex3;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        new MyThread(sharedResource, "T1").start();
        new MyThread(sharedResource, "T2").start();
    }
}
