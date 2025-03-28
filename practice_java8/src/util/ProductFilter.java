package ra.util;

import entity.Product;

@FunctionalInterface
public interface ProductFilter {
    boolean filter(Product product);
}