package org.example.order;

import org.example.cart.Cart;

import java.math.BigDecimal;

public class OrderImpl implements Order {

    // без magic
    public static final String DEFAULT_ADDRESS = "самовывоз";
    public static final DeliveryType DEFAULT_DELIVERY = DeliveryType.PICKUP;
    private static final BigDecimal STARTING_TOTAL = BigDecimal.ZERO;

    private static int counter = 1;

    private final int id;
    private final Cart cart;

    private DeliveryType deliveryType;
    private String address;
    private BigDecimal total;
    private boolean submitted = false;

    private OrderImpl(Cart cart) {
        this.id = counter++;
        this.cart = cart;
        this.deliveryType = DEFAULT_DELIVERY;
        this.address = DEFAULT_ADDRESS;
        this.total = STARTING_TOTAL;
    }

    @Override
    public void setDelivery(DeliveryType deliveryType) {
        this.total = total.add(cart.getTotal().add(deliveryType.getPrice()));
        this.deliveryType = deliveryType;

    }

    @Override
    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void submit() {
        this.submitted = true;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "\nЗаказ № " + id
                + "\n" + cart
                + "\nСпособ доставки: " + deliveryType
                + "\nАдрес доставки: " + address
                + "\nИтого: " + total + " руб.";
    }

    public static Order getNewOrder(Cart cart) {
        return new OrderImpl(cart);
    }
}
