package org.example.cart;

import org.example.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartImpl implements Cart {

    private static final BigDecimal STARTING_TOTAL = BigDecimal.ZERO;

    private final List<Product> cart = new ArrayList<>();
    private BigDecimal total = STARTING_TOTAL;

    private CartImpl() {
    }

    @Override
    public void addProduct(Product product) {
        cart.add(product);
        total = total.add(product.getPrice());
    }

    @Override
    public void removeProduct(int index) {
        total = total.subtract(cart.get(index).getPrice());
        cart.remove(index);
    }

    @Override
    public BigDecimal getTotal() {
        return total;
    }

    @Override
    public int size() {
        return cart.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nДобавленные товары: ");
        for (int i = 0; i < cart.size(); i++) {
            sb.append("\n").append(i + 1).append(". ").append(cart.get(i));
        }
        sb.append("\n").append("Всего на: ").append(total).append(" руб.\n");
        return sb.toString();
    }

    public static Cart getNewCart() {
        return new CartImpl();
    }
}
