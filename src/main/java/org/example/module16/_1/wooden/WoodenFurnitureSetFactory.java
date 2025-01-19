package org.example.module16._1.wooden;

import org.example.module16._1.Chair;
import org.example.module16._1.Closet;
import org.example.module16._1.FurnitureSetFactory;
import org.example.module16._1.Table;
import org.example.module16._1.metal.MetalChair;
import org.example.module16._1.metal.MetalCloset;
import org.example.module16._1.metal.MetalTable;

public class WoodenFurnitureSetFactory implements FurnitureSetFactory {
    @Override
    public Chair getChair() {
        return new WoodenChair();
    }

    @Override
    public Table getTable() {
        return new WoodenTable();
    }

    @Override
    public Closet getCloset() {
        return new WoodenCloset();
    }
}
