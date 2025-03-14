package Ex8;

public class Dog extends Animals {
    String breed ;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof Woof");
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Breed is "+breed);
    }

}
