package org.example.module16._3.factory;

import org.example.module16._3.transport.Plane;
import org.example.module16._3.transport.Transport;

public class PlaneFactory implements TransportFactory {
    @Override
    public Transport makeTransport() {
        return new Plane();
    }
}
