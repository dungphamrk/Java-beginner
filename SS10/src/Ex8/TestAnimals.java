package Ex8;

public class TestAnimals {
    public static void main(String[] args) {
        Animals [] animals = new Animals[100];
        Dog d1= new Dog("dog1",2,"aaa");
        animals[0]=d1;
        Cat c1= new Cat("cat1",2,"aaa");
        animals[1]=c1;
        int count =2;
        for (int i = 0; i < count; i++) {
            animals[i].displayInfo();
            animals[i].makeSound();
        }
    }
}
