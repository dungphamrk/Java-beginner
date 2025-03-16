package Ex9;

class Airplane extends Vehicle {
    int altitude;
    Airplane(int altitude) {
        this.altitude = altitude;
    }
    @Override
    void move() {
        System.out.println("Airplane di chuyển trên không ở độ cao: " + altitude + " mét.");
    }
    @Override
    void sound() {
        System.out.println("Airplane phát ra âm thanh: Whoosh");
    }
}
