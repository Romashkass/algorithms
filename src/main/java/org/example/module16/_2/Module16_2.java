package org.example.module16._2;

import org.example.IModule;
import org.example.module16._2.products.Product1;
import org.example.module16._2.products.Product2;

import java.util.Arrays;

public class Module16_2 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {}
        };
    }

    @Override
    public void execute(Object[][] data) {
        OrderBuilder orderBuilder = new OrderBuilder();

        Order order = orderBuilder
                .setAddress("somewhere here")
                .setPaymentMethod(PaymentMethod.CASH)
                .addProducts(Arrays.asList(
                        new Product1(),
                        new Product2()
                ))
                .build();
    }
}
