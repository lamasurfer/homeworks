package com.example.jdata_jdbc.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime date;
    private String productName;
    private int amount;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;

    public Order() {
    }

    public Order(int id, LocalDateTime date, String productName, int amount, Customer customer) {
        this.id = id;
        this.date = date;
        this.productName = productName;
        this.amount = amount;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                ", customer=" + customer +
                '}';
    }
}
