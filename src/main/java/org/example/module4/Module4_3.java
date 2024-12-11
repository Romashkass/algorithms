package org.example.module4;

import org.example.IModule;

import java.util.Arrays;
import java.util.Random;

public class Module4_3 implements IModule {
    enum STRATEGY {
        FIRST,
        LAST,
        RANDOM,
        MEDIAN
    }

    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {new int[]{13, 17, 37, 73, 31, 19, 23}, new int[]{13, 17, 19, 23, 31, 37, 73}},
                new Object[] {new int[]{13, 17, 37, 73, 31, 37, 19, 23}, new int[]{13, 17, 19, 23, 31, 37, 37, 73}},
                new Object[] {new int[]{18, 20, 3, 17}, new int[]{3, 17, 18, 20}},
                new Object[] {new int[]{0, 11, 0}, new int[]{0, 0, 11}},
                new Object[] {new int[]{0, 5, 5, 5, 6, 5, 5, 11, 5, 5, 5, 0, 5, 5}, new int[]{0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 11}},
                new Object[] {new int[]{8, 3, 2, 5, 1, 4, 7, 6}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}},
                new Object[] {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}},
        };
    }
    private int count = 0;
    private int countForEqual = 0;
    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            this.count = 0;
            this.countForEqual = 0;
            quickSort((int[])data[i][0], STRATEGY.FIRST);
            System.out.println("FIRST count: " + this.count + " + " + this.countForEqual + " = " + (this.count + this.countForEqual));
            this.count = 0;
            this.countForEqual = 0;
            quickSort((int[])data[i][0], STRATEGY.LAST);
            System.out.println("LAST count: " + this.count + " + " + this.countForEqual + " = " + (this.count + this.countForEqual));
            this.count = 0;
            this.countForEqual = 0;
            quickSort((int[])data[i][0], STRATEGY.MEDIAN);
            System.out.println("MEDIAN count: " + this.count + " + " + this.countForEqual + " = " + (this.count + this.countForEqual));
            this.count = 0;
            this.countForEqual = 0;
            for (int j = 0; j < 10; j++) {
                quickSort((int[])data[i][0], STRATEGY.RANDOM);
            }
            System.out.println("RANDOM count: " + (this.count / 10) + " + " + (this.countForEqual / 10) + " = " + ((this.count + this.countForEqual) / 10));
            this.count = 0;
            this.countForEqual = 0;

//            System.out.println("expected: " + Arrays.toString((int[])data[i][1]));
//            System.out.println("actual: " + Arrays.toString(actual));
        }
    }

    private int[] quickSort(int[] array, STRATEGY mode) {
        return recursiveQuickSort(array, 0, array.length, mode);
    }

    private int[] recursiveQuickSort(int[] array, int l, int r, STRATEGY mode) {
        if (r <= l) {
            return array;
        }
        int a = new Random().nextInt(l, r);

        switch (mode) {
            case FIRST:
                a = l;
                break;
            case LAST:
                a = r - 1;
                break;
            case RANDOM:
                a = new Random().nextInt(l, r);
                break;
            case MEDIAN:
                a = findMedian(array[l], array[(l + r) / 2], array[r - 1]);
                if (a == array[l]) {
                    a = l;
                } else if (a == array[r - 1]) {
                    a = r - 1;
                } else {
                    a = (l + r) / 2;
                }
                break;
        }

        swap(array, l, a);

        int i = l + 1;
        int pivot = array[l];
        for (int j = l + 1; j < r; j++) {
            this.count++;
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, l, i - 1);

        int middleSectionEnd = i;
        for (int j = i; j < r; j++) {
            this.countForEqual++;
            if (array[j] == pivot) {
                swap(array, middleSectionEnd, j);
                middleSectionEnd++;
            }
        }

        recursiveQuickSort(array, l, i - 1, mode);
        recursiveQuickSort(array, middleSectionEnd, r, mode);

        return array;
    }

    private void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    private int findMedian(int l, int m, int r) {
        return Math.max(Math.min(l, m), Math.min(m, r));
    }
}
