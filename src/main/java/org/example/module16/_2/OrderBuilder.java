package org.example.module16._2;

import org.example.module16._2.products.Product;

import java.util.List;

public class OrderBuilder {
    private Order order;

    public OrderBuilder() {
        order = new Order();
    }

    public OrderBuilder setAddress(String address) {
        order.setAddress(address);
        return this;
    }

    public OrderBuilder setPaymentMethod(PaymentMethod paymentMethod) {
        order.setPaymentMethod(paymentMethod);
        return this;
    }

    public OrderBuilder addProducts(List<Product> products) {
        for (Product product: products) {
            order.addProduct(product);
        }
        return this;
    }

    public OrderBuilder addProduct(Product product) {
        order.addProduct(product);
        return this;
    }

    public Order build() {
        return order;
    }
}
