package MyCode.Entity;

import java.util.Scanner;

public class Categories implements IApp {
    private static int countId =1;
    private int id;
    private String name;
    private  String description;
    private int priority;
    private boolean status;

    public Categories() {
    }

    public Categories( String name, int priority, String description, boolean status) {
        this.id = initialId();
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.status = status;
    }

    private int initialId(){
        return countId++;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()>6 && name.length()<50){
            this.name = name;
        }else {
            System.out.println("Tên ko hợp lệ");
        }
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        if(description.length()<255){
            this.description = description;
        }else {
            System.out.println("Mô tả không hợp lệ");
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
        System.out.println("Tên: "+ name);
        System.out.println("Độ ưu tiên: "+priority);
        System.out.println("Mô tả: " + description);
        System.out.println("Trạng thái: "+ (status?"Hoạt đông":"Không hoạt động"));
    }
    @Override
    public void inputData(Scanner sc) {
        do{
            System.out.print("Nhập tên danh mục (6-50 ký tự): ");
            String newName =sc.nextLine();
            setName(newName);
        }
        while (this.name.length() < 6 || this.name.length() > 50);

        System.out.print("Nhập độ ưu tiên: ");
        this.priority = Integer.parseInt(sc.nextLine());

        do{
            System.out.print("Nhập mô tả (tối đa 255 ký tự): ");
            String newDescription =sc.nextLine();
            setDescription(newDescription);
        }
        while (this.description.length() > 255);

        System.out.print("Nhập trạng thái (true/false): ");
        this.status = Boolean.parseBoolean(sc.nextLine());
    }
}
