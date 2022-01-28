package org.example.order;

public interface Order {

    void setDelivery(DeliveryType deliveryType);

    DeliveryType getDeliveryType();

    void setAddress(String address);

    void submit();

}
