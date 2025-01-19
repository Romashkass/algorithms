package org.example.module16._3;

import org.example.IModule;
import org.example.module16._3.factory.BicycleFactory;
import org.example.module16._3.factory.CarFactory;
import org.example.module16._3.factory.PlaneFactory;
import org.example.module16._3.factory.TransportFactory;
import org.example.module16._3.transport.Car;
import org.example.module16._3.transport.Transport;

public class Module16_3 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {}
        };
    }

    @Override
    public void execute(Object[][] data) {
        TransportFactory transportFactory = getTransportFactory("planea");
        Transport transport = transportFactory.makeTransport();
        transport.move();

    }

    static TransportFactory getTransportFactory(String transportType) {
        if (transportType.equalsIgnoreCase("bicycle")) {
            return new BicycleFactory();
        } else if (transportType.equalsIgnoreCase("car")) {
            return new CarFactory();
        } else if (transportType.equalsIgnoreCase("plane")) {
            return new PlaneFactory();
        }
        throw new RuntimeException("Transport type \'" + transportType + "\' is not exist");
    }
}
