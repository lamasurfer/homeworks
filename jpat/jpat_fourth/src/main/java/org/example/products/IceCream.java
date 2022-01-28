package org.example.products;

import java.math.BigDecimal;

public class IceCream extends AbstractProduct {

    public IceCream(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Мороженое " + super.toString();
    }
}
