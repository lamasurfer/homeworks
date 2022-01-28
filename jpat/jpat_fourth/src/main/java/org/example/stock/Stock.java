package org.example.stock;

import org.example.products.Product;

public interface Stock {

    Product getProduct(int index);

    boolean hasInStock(Product product);

    int size();

}
