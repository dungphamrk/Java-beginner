package Ex6;

public class Zoo {
    protected Animal[] animals = new Animal[100];
    protected int count = 0;

    public Zoo() {
    }

    public void addAnimal(Animal animal) {
        if (count < animals.length) {
            animals[count++] = animal;
        } else {
            System.out.println("Zoo is full!");
        }
    }
}
