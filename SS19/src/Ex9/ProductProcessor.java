package Ex9;

import java.util.List;

public interface ProductProcessor {
    double calculateTotalValue(List<Product> products);
    static void printProductList(List<Product> products){
        products.forEach(System.out::println);
    }
    default boolean hasExpensiveProduct(List<Product> products){
        return products.stream().anyMatch(product -> product.getPrice()>100);
    }
}
