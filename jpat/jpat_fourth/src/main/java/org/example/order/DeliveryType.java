package org.example.order;

import java.math.BigDecimal;

public enum DeliveryType {

    // также можно отнести к magic
    PICKUP("доставка самовывозом", BigDecimal.ZERO),
    COURIER("доставка курьером", BigDecimal.valueOf(500));

    private final String description;
    private final BigDecimal price;

    DeliveryType(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    // метод не зависит от номеров энамов, как было бы в случае со switch-case, добавление нового типа доставки
    // не повлияет на метод и его использование в коде далее
    public static void showDeliveryOptions() {
        System.out.println("Доступные способы доставки: ");
        for (DeliveryType value : DeliveryType.values()) {
            System.out.println((value.ordinal() + 1) + ". " + value);
        }
    }

    @Override
    public String toString() {
        return description + ", стоимость " + price + " руб.";
    }
}
