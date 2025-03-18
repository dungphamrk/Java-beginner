package ChatGPTCode.Entity;

import java.util.Scanner;

public class Categories implements ChatGPT.IApp {
    private static int countId = 1;
    private int id;
    private String name;
    private String description;
    private int priority;
    private boolean status;

    public Categories() {
        this.id = countId++;
    }

    public Categories(String name, int priority, String description, boolean status) {
        this.id = countId++;
        setName(name);
        setPriority(priority);
        setDescription(description);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        if (name.length() >= 6 && name.length() <= 50) {
            this.name = name;
        } else {
            System.out.println("Tên không hợp lệ (6-50 ký tự).");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description.trim();
        if (description.length() <= 255) {
            this.description = description;
        } else {
            System.out.println("Mô tả không hợp lệ (tối đa 255 ký tự).");
        }
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void displayData() {
        System.out.println("ID: " + id);
        System.out.println("Tên: " + name);
        System.out.println("Độ ưu tiên: " + priority);
        System.out.println("Mô tả: " + description);
        System.out.println("Trạng thái: " + (status ? "Hoạt động" : "Không hoạt động"));
    }

    @Override
    public void inputData(Scanner sc) {
        this.name = inputString(sc, "Nhập tên danh mục (6-50 ký tự): ", 6, 50);
        this.priority = inputInt(sc, "Nhập độ ưu tiên: ");
        this.description = inputString(sc, "Nhập mô tả (tối đa 255 ký tự): ", 0, 255);
        this.status = inputBoolean(sc, "Nhập trạng thái (true/false): ");
    }

    private String inputString(Scanner sc, String message, int min, int max) {
        String input;
        do {
            System.out.print(message);
            input = sc.nextLine().trim();
            if (input.length() >= min && input.length() <= max) {
                return input;
            }
            System.out.println("Lỗi: Độ dài ký tự phải từ " + min + " đến " + max + ".");
        } while (true);
    }

    private int inputInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private boolean inputBoolean(Scanner sc, String message) {
        System.out.print(message);
        return Boolean.parseBoolean(sc.nextLine().trim());
    }
}
