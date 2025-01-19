package org.example.module16._1.metal;

import org.example.module16._1.Chair;

public class MetalChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Sit on a metal chair");
    }
}
