package Ex1;

public class MyThread extends  Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Thread đang chạy "+ this.getName()    );
    }
}
