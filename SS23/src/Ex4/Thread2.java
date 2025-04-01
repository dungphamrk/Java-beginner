package Ex4;

public class Thread2 extends Thread1 {
    private Thread1 thread2;

    public Thread2(Thread1 thread2) {
        this.thread2 = thread2;
    }

    @Override
    public void run() {
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread 2 bắt đầu .....");
    }
}
