package org.example.module5;

import org.example.IModule;

import java.util.Random;

public class Module5 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {new int[] {9, 1, 0, 2, 3, 4, 6, 8, 7, 10, 5}, 6, 5},
        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            int actual = rSelect((int[])data[i][0], (int)data[i][1]);
            System.out.println("expected: " + data[i][2]);
            System.out.println("actual: " + actual);
        }
    }

    private int rSelect(int[] array, int k) {
        return recursiveRSelect(array, 0, array.length, k);
    }

    private int recursiveRSelect(int[] array, int l, int r, int k) {
        if (r == l) {
            return array[l];
        }
        int j = partition(array, l, r);

        if (j == k) {
            return array[j];
        } else if (j > k) {
            return recursiveRSelect(array, l, j, k);
        } else {
            return recursiveRSelect(array, j + 1, r, k - j);
        }
    }

    private int partition(int[] array, int l, int r) {
        int a = new Random().nextInt(l, r);
        swap(array, l, a);

        int i = l + 1;
        int pivot = array[l];
        for (int j = l + 1; j < r; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, l, i - 1);
        return i - 1;
    }

    private void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
