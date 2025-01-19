package org.example.module16._3.factory;

import org.example.module16._3.transport.Car;
import org.example.module16._3.transport.Transport;

public class CarFactory implements TransportFactory {
    @Override
    public Transport makeTransport() {
        return new Car();
    }
}
