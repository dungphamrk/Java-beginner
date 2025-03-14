package Ex8;

public class Cat extends Animals {
    String furColor;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.furColor = color;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println( "Fur color: " + furColor);
    }
}
