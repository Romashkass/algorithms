package org.example.module4;

import org.example.IModule;

import java.util.Arrays;
import java.util.Random;

public class Module4_1 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {new int[]{13, 17, 37, 73, 31, 19, 23}, new int[]{13, 17, 19, 23, 31, 37, 73}},
                new Object[] {new int[]{13, 17, 37, 73, 31, 37, 19, 23}, new int[]{13, 17, 19, 23, 31, 37, 37, 73}},
                new Object[] {new int[]{18, 20, 3, 17}, new int[]{3, 17, 18, 20}},
                new Object[] {new int[]{0, 11, 0}, new int[]{0, 0, 11}},
                new Object[] {new int[]{0, 5, 5, 5, 6, 5, 5, 11, 5, 5, 5, 0, 5, 5}, new int[]{0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 11}},
        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            int[] actual = quickSort((int[])data[i][0]);
            System.out.println("expected: " + Arrays.toString((int[])data[i][1]));
            System.out.println("actual: " + Arrays.toString(actual));
        }
    }

    private int[] quickSort(int[] array) {
        return recursiveQuickSort(array, 0, array.length);
    }

    private int[] recursiveQuickSort(int[] array, int l, int r) {
        if (r <= l) {
            return array;
        }
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

        int middleSectionEnd = i;
        for (int j = i; j < r; j++) {
            if (array[j] == pivot) {
                swap(array, middleSectionEnd, j);
                middleSectionEnd++;
            }
        }

        recursiveQuickSort(array, l, i - 1);
        recursiveQuickSort(array, middleSectionEnd, r);

        return array;
    }

    private void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

}
