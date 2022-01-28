package org.example.products;

import java.math.BigDecimal;

public class DiscountCart extends AbstractProduct {

    private final String description;

    public DiscountCart(String name, BigDecimal price, String description) {
        super(name, price);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + description;
    }
}
