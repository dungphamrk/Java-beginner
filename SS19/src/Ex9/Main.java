package Ex9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(5000,"Phone"));
        productList.add(new Product(200,"Table"));
        productList.add(new Product(30,"Laptop"));
        productList.add(new Product(12,"Headphone"));
        List<Product> expProducts = productList.stream().filter(product -> product.getPrice() >= 100).toList();
        ProductProcessorImpl  productProcessor = new ProductProcessorImpl();

        if(productProcessor.hasExpensiveProduct(productList)){
            System.out.println("Các sản phẩm cao cấp là: ");
            ProductProcessor.printProductList(expProducts);
        }else{
            System.out.println("Không có sản phẩm cao cấp");
        }

        System.out.print("Tổng giá trị của các sản phẩm là:");
        System.out.println(productProcessor.calculateTotalValue(productList));

        System.out.println("Danh sách sản phẩm là: ");
        ProductProcessor.printProductList(productList);

    }
}
