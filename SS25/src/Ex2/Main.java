package Ex2;

public class Main {
    public static void main(String[] args) {
        try {
            // Sử dụng AnimalFactory để tạo các đối tượng
            Animal dog = AnimalFactory.createAnimal("dog", "Buddy");
            Animal cat = AnimalFactory.createAnimal("cat", "Whiskers");

            // Kiểm tra kết quả
            System.out.println("Testing Dog:");
            System.out.println("Name: " + dog.getName());
            System.out.println("Sound: " + dog.speak());
            System.out.println("Is instance of Dog: " + (dog instanceof Dog));

            System.out.println("\nTesting Cat:");
            System.out.println("Name: " + cat.getName());
            System.out.println("Sound: " + cat.speak());
            System.out.println("Is instance of Cat: " + (cat instanceof Cat));

            // Thử tạo một loại động vật không tồn tại
            System.out.println("\nTesting invalid animal:");
            Animal invalid = AnimalFactory.createAnimal("bird", "Tweety");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}