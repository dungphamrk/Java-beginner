package Ex4;

public class Book {
    private String title;
    private String author;
    private int price;

    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public int getPrice(){
        return this.price;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPrice(int price){
        if(price > 0)
            this.price = price;
        else
            System.out.println("giá không được âm");
    }

}
