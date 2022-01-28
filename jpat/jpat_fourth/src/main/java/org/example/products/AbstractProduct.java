package org.example.products;

import java.math.BigDecimal;

public abstract class AbstractProduct implements Product {

    private final String name;
    private final BigDecimal price;

    public AbstractProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " " + price + " руб.";

    }
}
