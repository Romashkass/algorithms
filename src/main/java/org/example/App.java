package org.example;

import org.example.module6.Module6_1;

public class App {
    public static void main( String[] args ) {
        IModule iModule = new Module6_1();
        iModule.execute(iModule.dataProvider());
    }
}
