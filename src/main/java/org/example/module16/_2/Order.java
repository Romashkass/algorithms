package org.example.module16._2;

import org.example.module16._2.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String address;
    private PaymentMethod paymentMethod;
    private List<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return "Order:\n" +
                "address: " + address + "\n" +
                "paymentMethod: " + paymentMethod + "\n" +
                "products: " + products + "\n";
    }
}
