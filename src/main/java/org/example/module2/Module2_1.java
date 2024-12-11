package org.example.module2;

import org.example.IModule;

import java.util.Arrays;

public class Module2_1 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {7, new int[]{13, 17, 37, 73, 31, 19, 23}, new int[]{13, 17, 19, 23, 31, 37, 73}},
                new Object[] {6, new int[]{12, 18, 7, 11, 5, 17}, new int[]{5, 7, 11, 12, 17, 18}},
                new Object[] {3, new int[]{1, 2, 3}, new int[]{1, 2, 3}},
        };
    }
    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            int[] actual = selectionSort((int)data[i][0], (int[])data[i][1]);
            System.out.println("expected: " + Arrays.toString((int[])data[i][2]));
            System.out.println("actual: " + Arrays.toString(actual));
        }
    }

    private int[] selectionSort(int count, int[] array) {
        for (int i = 0; i < count; i++) {
            int minElement = array[i];
            int minElementIndex = i;
            for (int j = i; j < count; j++) {
                if (array[j] < minElement) {
                    minElement = array[j];
                    minElementIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minElementIndex];
            array[minElementIndex] = tmp;
        }
        return array;
    }
}
