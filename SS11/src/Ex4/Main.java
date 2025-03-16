package Ex4;

public class Main {
    public static void main(String[] args) {
        Electronic [] listElt = {new TV(),new Radio()};
        for(Electronic electronic : listElt) {
            electronic.turnOff();
            electronic.turnOn();
        }

    }
}
