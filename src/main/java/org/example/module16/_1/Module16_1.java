package org.example.module16._1;

import org.example.IModule;
import org.example.module16._1.metal.MetalFurnitureSetFactory;
import org.example.module16._1.wooden.WoodenFurnitureSetFactory;

public class Module16_1 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {}
        };
    }

    @Override
    public void execute(Object[][] data) {
        FurnitureSetFactory furnitureSetFactory = new MetalFurnitureSetFactory();
        Closet closet1 = furnitureSetFactory.getCloset();
        Table table1 = furnitureSetFactory.getTable();
        Chair chair1 = furnitureSetFactory.getChair();

        closet1.putClothes();
        table1.putTheBook();
        chair1.sit();
    }
}
