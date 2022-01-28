package org.example.data;

import org.example.products.DiscountCart;
import org.example.products.IceCream;
import org.example.products.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class LoaderImpl implements Loader {

    private LoaderImpl() {
    }

    @Override
    public List<Product> provide() {
        return Arrays.asList(
                new IceCream("Рожок", new BigDecimal(70)),
                new IceCream("Стаканчик", new BigDecimal(60)),
                new IceCream("Лакомка", new BigDecimal(90)),
                new IceCream("Эскимо", new BigDecimal(70)),
                new IceCream("Пломбир", new BigDecimal(250)),
                new DiscountCart("Скидочная карта", new BigDecimal("1499.99"), " скидка 5 %")
        );
    }

    public static Loader getNewLoader() {
        return new LoaderImpl();
    }
}
