package Ex5;
public class Main {
    public static void main(String[] args) {
        SharedData shareData = new SharedData();
        Writer writer = new Writer(shareData);
        Reader reader = new Reader(shareData);

        writer.start();
        reader.start();
    }
}
