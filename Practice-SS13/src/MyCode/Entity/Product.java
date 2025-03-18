package MyCode.Entity;

import java.util.Scanner;

public class Product implements IApp {
    private String productId;
    private String name;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String description;
    private int quantity;
    private int categoryId;
    private int status;

    public Product() {}

    public Product(String description, float exportPrice, float importPrice, String name, String productId, int quantity, int status, String title, int categoryId) {
        setDescription(description);
        setExportPrice(exportPrice);
        setImportPrice(importPrice);
        setName(name);
        setProductId(productId);
        setQuantity(quantity);
        setStatus(status);
        setTitle(title);
        setCategoryId(categoryId);
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        while (exportPrice < importPrice * INTEREST) {
            System.out.print("Giá xuất phải lớn hơn hoặc bằng " + INTEREST + " lần giá nhập!: ");
            exportPrice = new Scanner(System.in).nextFloat();
        }
        this.exportPrice = exportPrice;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        while (importPrice <= 0) {
            System.out.print("Giá nhập phải lớn hơn 0!: ");
            importPrice = new Scanner(System.in).nextFloat();
        }
        this.importPrice = importPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        while (name.length() < 10 || name.length() > 100) {
            System.out.print("Tên sản phẩm phải từ 10 đến 100 ký tự! : ");
            name = new Scanner(System.in).nextLine();
        }
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        while (!productId.matches("[CET]\\d{4}")) {
            System.out.print("Mã sản phẩm phải có định dạng C/E/T + 4 chữ số!: ");
            productId = new Scanner(System.in).nextLine();
        }
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        while (quantity < 0) {
            System.out.print("Số lượng không thể âm!: ");
            quantity = new Scanner(System.in).nextInt();
        }
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        while (status < 0 || status > 2) {
            System.out.print("Trạng thái phải là 0 (Hoạt động), 1 (Hết hàng) hoặc 2 (Không hoạt động)! Nhập lại: ");
            status = new Scanner(System.in).nextInt();
        }
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        while (title.length() > 200) {
            System.out.print("Tiêu đề không được vượt quá 200 ký tự: ");
            title = new Scanner(System.in).nextLine();
        }
        this.title = title;
    }

    @Override
    public void inputData(Scanner scanner) {
        setProductId(scanner.nextLine());
        setName(scanner.nextLine());
        setImportPrice(scanner.nextFloat());
        setExportPrice(scanner.nextFloat());
        scanner.nextLine();
        setTitle(scanner.nextLine());
        setDescription(scanner.nextLine());
        setQuantity(scanner.nextInt());
        setCategoryId(scanner.nextInt());
        setStatus(scanner.nextInt());
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Tên: " + name);
        System.out.println("Giá Nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Mô tả: " + description);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã danh mục: " + categoryId);
        System.out.println("Trạng thái: " + (status == 0 ? "Hoạt động" : status == 1 ? "Hết hàng" : "Không hoạt động"));
    }
}
