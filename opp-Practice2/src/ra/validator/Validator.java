package ra.validator;

import ra.entity.Product;

public class Validator {
    public static boolean isValidProductId(String id) {
        return id != null && id.length() == 4 && !Product.getProducts().stream()
                .anyMatch(p -> p.getProductId().equalsIgnoreCase(id));
    }

    public static boolean isValidProductName(String name) {
        return name != null && name.length() >= 6 && name.length() <= 50 && !Product.getProducts().stream()
                .anyMatch(p -> p.getProductName().equalsIgnoreCase(name));
    }

    public static boolean isValidImportPrice(float price) {
        return price > 0;
    }

    public static boolean isValidExportPrice(float exportPrice, float importPrice) {
        return exportPrice >= importPrice * 1.2f;
    }

    public static boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }
}