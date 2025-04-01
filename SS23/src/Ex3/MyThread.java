package Ex3;

class MyThread extends Thread {
    private SharedResource resource;

    public MyThread(SharedResource resource, String name) {
        super(name);
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println("Luồng : " + Thread.currentThread().getName() );
        resource.printAlphabet();
    }
}