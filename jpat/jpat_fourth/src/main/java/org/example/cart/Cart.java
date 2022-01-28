package org.example.cart;

import org.example.products.Product;

import java.math.BigDecimal;

public interface Cart {

    void addProduct(Product product);

    void removeProduct(int index);

    BigDecimal getTotal();

    int size();

}
