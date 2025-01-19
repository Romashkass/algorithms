package org.example.module16._3.factory;

import org.example.module16._3.transport.Bicycle;
import org.example.module16._3.transport.Transport;

public class BicycleFactory implements TransportFactory {
    @Override
    public Transport makeTransport() {
        return new Bicycle();
    }
}
