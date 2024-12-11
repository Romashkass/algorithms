package org.example.module2;

import org.example.IModule;

import java.util.Arrays;

public class Module2_3 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {7, new int[]{13, 17, 37, 73, 31, 19, 23}, new int[]{13, 17, 19, 23, 31, 37, 73}},
                new Object[] {4, new int[]{18, 20, 3, 17}, new int[]{3, 17, 18, 20}},
                new Object[] {3, new int[]{0, 11, 0}, new int[]{0, 0, 11}},
        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            int[] actual = mergeSort((int[])data[i][1]);
            System.out.println("expected: " + Arrays.toString((int[])data[i][2]));
            System.out.println("actual: " + Arrays.toString(actual));
        }
    }

    private int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, array.length / 2));
        int[] right = mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length));

        return merge(left, right);
    }

    private int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];

        int k = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length || j < array2.length) {
            if (i == array1.length) {
                result[k] = array2[j];
                j++;
                k++;
                continue;
            }
            if (j == array2.length) {
                result[k] = array1[i];
                i++;
                k++;
                continue;
            }

            if (array1[i] <= array2[j]) {
                result[k] = array1[i];
                i++;
                k++;
            } else {
                result[k] = array2[j];
                j++;
                k++;
            }
        }

        return result;
    }
}
