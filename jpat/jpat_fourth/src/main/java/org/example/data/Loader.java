package org.example.data;

import org.example.products.Product;

import java.util.List;

public interface Loader {

    List<Product> provide();
}
