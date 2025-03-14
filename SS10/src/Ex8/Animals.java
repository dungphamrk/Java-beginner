package Ex8;

public class Animals {
    String name ;
    int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
    public void makeSound(){
        System.out.println("Some generic sound");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
