package business.model;
import java.util.Scanner;

public class ClassRoom {
    private int id;
    private String name;
    private int capacity;
    private boolean status;

    public ClassRoom() {
    }

    public ClassRoom(int id, String name, int capacity, boolean status) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào tên lớp học:");
        this.name = scanner.nextLine();
        System.out.println("Nhập vào sức chứa lớp học:");
        this.capacity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào trạng thái lớp học (true/false):");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Mã lớp: " + this.id + " - Tên lớp: " + this.name +
                " - Sức chứa: " + this.capacity + " - Trạng thái: " + this.status;
    }
}