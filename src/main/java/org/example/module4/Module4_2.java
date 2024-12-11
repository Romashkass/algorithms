package org.example.module4;

import org.example.IModule;

import java.util.Arrays;

public class Module4_2 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {2, new int[]{2, 1}},
                new Object[] {4, new int[]{2, 4, 1, 3}},
        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            int[] actual = doArray((int)data[i][0]);
            System.out.println("expected: " + Arrays.toString((int[])data[i][1]));
            System.out.println("actual: " + Arrays.toString(actual));
        }
    }

    private int[] doArray(int len) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = i + 1;
        }

        return recursiveDoArray(array, len - 1, len);
    }

    private int[] recursiveDoArray(int[] array, int l, int r) {
        if (l < 0) {
            return array;
        }
        int m = (l + r) / 2;
        swap(array, l, m);
        recursiveDoArray(array, l - 1, r);
        return array;
    }

    private void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
