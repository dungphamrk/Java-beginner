package Ex2;

class AnimalFactory {
    public static Animal createAnimal(String type, String name) {
        if (type == null) {
            return null;
        }
        switch (type.toLowerCase()) {
            case "dog":
                return new Dog(name);
            case "cat":
                return new Cat(name);
            default:
                throw new IllegalArgumentException("Unknown animal type: " + type);
        }
    }
}
