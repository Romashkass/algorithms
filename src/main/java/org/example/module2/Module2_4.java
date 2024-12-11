package org.example.module2;

import org.example.IModule;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Map. Entry;

public class Module2_4 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {new int[]{1, 2, 3, 4, 5, 6}, 0},
                new Object[] {new int[]{1, 3, 5, 2, 4, 6}, 3},
                new Object[] {new int[]{1, 5, 3, 2, 6, 4}, 5},
                new Object[] {new int[]{1, 5, 3, 2, 6, 4, 7}, 5},
                new Object[] {new int[]{6, 5, 4, 3, 2, 1}, 15},
                new Object[] {new int[]{6, 5, 4, 3, 2, 1, 7}, 15},
        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            Entry<Integer, int[]> actual = countInv((int[])data[i][0]);
            System.out.println("expected: " + (int)data[i][1]);
            System.out.println("actual: " + actual.getKey());
        }
    }

    private Entry<Integer, int[]> countInv(int[] array) {
        if (array.length == 1) {
            return new SimpleEntry<>(0, array);
        }

        Entry<Integer, int[]> left = countInv(Arrays.copyOfRange(array, 0, array.length / 2));
        Entry<Integer, int[]> right = countInv(Arrays.copyOfRange(array, array.length / 2, array.length));
        Entry<Integer, int[]> split = countSplitInv(left.getValue(), right.getValue());

        return new SimpleEntry<>(left.getKey() + right.getKey() + split.getKey(), split.getValue());
    }

    private Entry<Integer, int[]> countSplitInv(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int invCount = 0;

        int k = 0;
        int i = 0;
        int j = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                result[k] = right[j];
                j++;
                k++;
                continue;
            }
            if (j == right.length) {
                result[k] = left[i];
                i++;
                k++;
                continue;
            }

            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
                k++;
            } else {
                result[k] = right[j];
                j++;
                k++;
                invCount += left.length - i;
            }
        }

        return new SimpleEntry<>(invCount, result);
    }
}
