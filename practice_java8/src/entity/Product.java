package entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Product implements IProduct {
    private static int countId = 1;
    private int productId;
    private String productName;
    private float price;
    private String category;
    private LocalDate createdDate;

    public Product() {
        this.productId = countId++;
        this.createdDate = LocalDate.now();
    }

    public Product(int productId, String productName, float price, String category, LocalDate createdDate) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.createdDate = createdDate;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();

        System.out.print("Nhập giá tiền: ");
        this.price = Float.parseFloat(scanner.nextLine());

        System.out.print("Nhập danh mục: ");
        this.category = scanner.nextLine();
    }

    @Override
    public void displayData() {
        System.out.println("ID: " + productId + ", Name: " + productName + ", Price: " + price + ", Category: " + category + ", Created Date: " + createdDate);
    }
}