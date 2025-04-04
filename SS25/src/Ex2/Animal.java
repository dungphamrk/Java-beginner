package Ex2;

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String speak();

    public String getName() {
        return name;
    }
}




