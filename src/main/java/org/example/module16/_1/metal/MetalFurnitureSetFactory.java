package org.example.module16._1.metal;

import org.example.module16._1.Chair;
import org.example.module16._1.Closet;
import org.example.module16._1.FurnitureSetFactory;
import org.example.module16._1.Table;
import org.example.module16._1.wooden.WoodenChair;
import org.example.module16._1.wooden.WoodenCloset;
import org.example.module16._1.wooden.WoodenTable;

public class MetalFurnitureSetFactory implements FurnitureSetFactory {
    @Override
    public Chair getChair() {
        return new MetalChair();
    }

    @Override
    public Table getTable() {
        return new MetalTable();
    }

    @Override
    public Closet getCloset() {
        return new MetalCloset();
    }
}
