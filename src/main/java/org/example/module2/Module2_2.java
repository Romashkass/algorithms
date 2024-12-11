package org.example.module2;

import org.example.IModule;

import java.util.Arrays;

public class Module2_2 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {3, 3, new int[]{1, 2, 3}, 2, new int[]{1, 2}, 4, new int[]{3, 5, 6, 7}, new int[]{1, 1, 2, 2, 3, 3, 5, 6, 7}},
                new Object[] {2, 2, new int[]{1, 10}, 3, new int[]{7, 9, 11}, new int[]{1, 7, 9, 10, 11}},
                new Object[] {1, 10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}},
        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            int arraysCount = (int)data[i][0];

            int[] mergedArray = null;
            for (int j = 1; j <= arraysCount; j++) {
                int[] array = (int[])data[i][j*2];

                if (mergedArray == null) {
                    mergedArray = array.clone();
                } else {
                    mergedArray = merge(mergedArray, array);
                }
            }

            System.out.println("expected: " + Arrays.toString((int[])data[i][arraysCount*2 + 1]));
            System.out.println("actual: " + Arrays.toString(mergedArray));
        }
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
