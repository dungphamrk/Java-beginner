package Ex10;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> cartItems;
    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }
    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Lỗi: Số lượng không hợp lệ!");
            return;
        }

        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId().equals(product.getId())) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public void removeFromCart(String productId){
        boolean removed = cartItems.removeIf(cartItem -> cartItem.getProduct().getId().equals(productId));
        if (removed) {
            System.out.println("Sản phẩm đã được xóa khỏi giỏ hàng.");
        } else {
            System.out.println("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
        }
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Giỏ hàng trống.");
        } else {
            System.out.println("Giỏ hàng của bạn:");
            for (CartItem item : cartItems) {
                System.out.println(item);
            }
        }

    }

    public void checkout() {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        System.out.println("Tổng tiền cần thanh toán: " + total);
    }
}