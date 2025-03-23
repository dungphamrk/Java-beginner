package ra.entity;

import ra.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;
    private static List<Product> products = new ArrayList<>();

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice,
                   int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
        this.calProfit();
    }

    public void inputData(Scanner scanner) {
        this.productId = inputProductId(scanner);
        this.productName = inputProductName(scanner);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.quantity = inputQuantity(scanner);
        this.descriptions = inputDescriptions(scanner);
        this.status = inputStatus(scanner);
        this.calProfit();
        products.add(this);
    }
    public void displayData() {
        System.out.printf("Mã SP: %s | Tên SP: %s | Giá nhập: %.2f | Giá xuất: %.2f | " +
                        "Lợi nhuận: %.2f | Số lượng: %d | Mô tả: %s | Trạng thái: %s\n",
                productId, productName, importPrice, exportPrice, profit, quantity,
                descriptions, status ? "Đang bán" : "Không bán");
    }

    public void calProfit() {
        this.profit = exportPrice - importPrice;
    }

    private String inputProductId(Scanner scanner) {
        String id;
        do {
            System.out.print("Nhập mã sản phẩm (4 ký tự, không trùng): ");
            id = scanner.nextLine();
            if (!Validator.isValidProductId(id)) {
                System.out.println("Mã sản phẩm không hợp lệ hoặc bị trùng!");
            }
        } while (!Validator.isValidProductId(id));
        return id;
    }

    private String inputProductName(Scanner scanner) {
        String name;
        do {
            System.out.print("Nhập tên sản phẩm (6-50 ký tự, không trùng): ");
            name = scanner.nextLine();
            if (!Validator.isValidProductName(name)) {
                System.out.println("Tên sản phẩm không hợp lệ hoặc bị trùng!");
            }
        } while (!Validator.isValidProductName(name));
        return name;
    }

    private float inputImportPrice(Scanner scanner) {
        float price;
        do {
            System.out.print("Nhập giá nhập (lớn hơn 0): ");
            price = Float.parseFloat(scanner.nextLine());
            if (!Validator.isValidImportPrice(price)) {
                System.out.println("Giá nhập phải lớn hơn 0!");
            }
        } while (!Validator.isValidImportPrice(price));
        return price;
    }

    private float inputExportPrice(Scanner scanner) {
        float price;
        do {
            System.out.print("Nhập giá xuất (lớn hơn ít nhất 20% so với giá nhập): ");
            price = Float.parseFloat(scanner.nextLine());
            if (!Validator.isValidExportPrice(price, importPrice)) {
                System.out.println("Giá xuất phải lớn hơn ít nhất 20% so với giá nhập!");
            }
        } while (!Validator.isValidExportPrice(price, importPrice));
        return price;
    }

    private int inputQuantity(Scanner scanner) {
        int qty;
        do {
            System.out.print("Nhập số lượng sản phẩm (lớn hơn 0): ");
            qty = Integer.parseInt(scanner.nextLine());
            if (!Validator.isValidQuantity(qty)) {
                System.out.println("Số lượng phải lớn hơn 0!");
            }
        } while (!Validator.isValidQuantity(qty));
        return qty;
    }

    private String inputDescriptions(Scanner scanner) {
        System.out.print("Nhập mô tả sản phẩm: ");
        return scanner.nextLine();
    }

    private boolean inputStatus(Scanner scanner) {
        System.out.print("Nhập trạng thái (true - Đang bán, false - Không bán): ");
        return Boolean.parseBoolean(scanner.nextLine());
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getProfit() {
        return profit;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static List<Product> getProducts() {
        return products;
    }
}