package org.example;

import org.example.module6.Module6_1;
import org.example.module6.Module6_2;
import org.example.module6.Module6_3;

public class App {
    public static void main( String[] args ) {
        IModule iModule = new Module6_2();
        iModule.execute(iModule.dataProvider());
    }
}
