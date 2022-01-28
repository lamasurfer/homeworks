package org.example.stock;

import org.example.data.Loader;
import org.example.products.Product;

import java.util.List;

public class StockImpl implements Stock {

    private final List<Product> stock;

    private StockImpl(Loader loader) {
        this.stock = loader.provide();
    }

    @Override
    public Product getProduct(int index) {
        return stock.get(index);
    }

    @Override
    public boolean hasInStock(Product product) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public int size() {
        return stock.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nДоступные товары: ");
        for (int i = 0; i < stock.size(); i++) {
            sb.append("\n").append(i + 1).append(". ").append(stock.get(i));
        }
        sb.append("\n");
        return sb.toString();
    }

    public static Stock getNewStock(Loader loader) {
        return new StockImpl(loader);
    }
}
