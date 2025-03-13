package Ex4;

public class TestBook {
    public static void main(String[] args) {
        Book b1=new Book();
        b1.setPrice(123);
        b1.setAuthor("Dũng");
        b1.setTitle("I don't know");
        System.out.println("Giá: "+ b1.getPrice());
        b1.setPrice(-1123);
    }
}
