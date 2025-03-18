package ChatGPTCode.Entity;

import java.util.Scanner;

public class Product implements ChatGPTCode.Entity.IApp {
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

    public Product(String productId, String name, float importPrice, float exportPrice, String title,
                   String description, int quantity, int categoryId, int status) {
        this.productId = productId;
        this.name = name;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.status = status;
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
        this.description = description.trim();
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        if (exportPrice >= importPrice * INTEREST) {
            this.exportPrice = exportPrice;
        } else {
            System.out.println("Lỗi: Giá xuất phải lớn hơn hoặc bằng " + INTEREST + " lần giá nhập!");
        }
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        if (importPrice > 0) {
            this.importPrice = importPrice;
        } else {
            System.out.println("Lỗi: Giá nhập phải lớn hơn 0!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        if (name.length() >= 10 && name.length() <= 100) {
            this.name = name;
        } else {
            System.out.println("Lỗi: Tên sản phẩm phải từ 10 đến 100 ký tự!");
        }
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        if (productId.matches("[CET]\\d{4}")) {
            this.productId = productId;
        } else {
            System.out.println("Lỗi: Mã sản phẩm phải có định dạng C/E/T + 4 chữ số!");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Lỗi: Số lượng không thể âm!");
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (status >= 0 && status <= 2) {
            this.status = status;
        } else {
            System.out.println("Lỗi: Trạng thái phải là 0 (Hoạt động), 1 (Hết hàng) hoặc 2 (Không hoạt động)!");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title.trim();
        if (title.length() <= 200) {
            this.title = title;
        } else {
            System.out.println("Lỗi: Tiêu đề không được vượt quá 200 ký tự!");
        }
    }

    @Override
    public void inputData(Scanner scanner) {
        this.productId = inputString(scanner, "Nhập mã sản phẩm (C/E/T + 4 số): ", "[CET]\\d{4}");
        this.name = inputString(scanner, "Nhập tên sản phẩm (10-100 ký tự): ", 10, 100);
        this.importPrice = inputFloat(scanner, "Nhập giá nhập (lớn hơn 0): ", 0);
        this.exportPrice = inputFloat(scanner, "Nhập giá xuất (lớn hơn hoặc bằng " + INTEREST + " lần giá nhập): ", (float) (importPrice * INTEREST));
        this.title = inputString(scanner, "Nhập tiêu đề (tối đa 200 ký tự): ", 0, 200);
        this.description = scanner.nextLine().trim();
        this.quantity = inputInt(scanner, "Nhập số lượng (>= 0): ", 0);
        this.categoryId = inputInt(scanner, "Nhập mã danh mục: ", 0);
        this.status = inputInt(scanner, "Nhập trạng thái (0: Hoạt động, 1: Hết hàng, 2: Không hoạt động): ", 0, 2);
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Tên: " + name);
        System.out.println("Giá Nhập: " + importPrice);
        System.out.println("Giá Xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Mô tả: " + description);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã danh mục: " + categoryId);
        System.out.println("Trạng thái: " + (status == 0 ? "Hoạt động" : status == 1 ? "Hết hàng" : "Không hoạt động"));
    }

    private String inputString(Scanner scanner, String message, String regex) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.matches(regex)) {
                return input;
            }
            System.out.println("Lỗi: Dữ liệu không hợp lệ!");
        } while (true);
    }

    private String inputString(Scanner scanner, String message, int min, int max) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.length() >= min && input.length() <= max) {
                return input;
            }
            System.out.println("Lỗi: Độ dài phải từ " + min + " đến " + max + " ký tự!");
        } while (true);
    }

    private float inputFloat(Scanner scanner, String message, float min) {
        while (true) {
            try {
                System.out.print(message);
                float value = Float.parseFloat(scanner.nextLine().trim());
                if (value >= min) {
                    return value;
                }
                System.out.println("Lỗi: Giá trị phải >= " + min);
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
            }
        }
    }

    private int inputInt(Scanner scanner, String message, int min) {
        return inputInt(scanner, message, min, Integer.MAX_VALUE);
    }

    private int inputInt(Scanner scanner, String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Lỗi: Giá trị phải từ " + min + " đến " + max);
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }
}
