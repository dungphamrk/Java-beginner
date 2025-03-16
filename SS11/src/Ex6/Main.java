package Ex6;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Lion lion = new Lion("haha", 5);
        Elephant elephant = new Elephant("blabla", 10);

        zoo.addAnimal(lion);
        zoo.addAnimal(elephant);

        for (int i = 0; i < zoo.count; i++) {
            zoo.animals[i].sound();
            zoo.animals[i].move();
        }
    }
}
