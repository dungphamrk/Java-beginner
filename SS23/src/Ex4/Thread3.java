package Ex4;

public class Thread3 extends Thread1 {
    private Thread1 thread3;

    public Thread3(Thread1 thread3) {
        this.thread3 = thread3;
    }

    @Override
    public void run() {
        try {
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread 3 bắt đầu ....");
    }
}
