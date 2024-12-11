package org.example.module3;

import org.example.IModule;

public class Module3 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {26, 43, 1118},
                new Object[] {1234, 1234, 1522756},
                new Object[] {46, 134, 6164},
                new Object[] {1234, 5678, 7006652},
                new Object[] {4781, 71, 339451},
                new Object[] {4, 12, 48},
                new Object[] {381, 746, 284226},
                new Object[] {47164, 1584, 74707776},
                new Object[] {47164, 1, 47164},
                new Object[] {47164, 39999, 1886512836},
                new Object[] {26, -43, -1118},
                new Object[] {-26, -43, 1118},
                new Object[] {-26, 43, -1118},
        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i + " : " + (int)data[i][0] + "*" + (int)data[i][1]);
            int actual = karatsuba((int)data[i][0], (int)data[i][1]);
            System.out.println("expected: " + (int)data[i][2]);
            System.out.println("actual: " + actual);
        }
    }

    private int karatsuba(int a, int b) {
        if (a < 0) {
            return -karatsuba(-a, b);
        }
        if (b < 0) {
            return -karatsuba(a, -b);
        }

        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);

        if (aStr.length() > bStr.length()) {
            int n = aStr.length() - bStr.length();
            for (int i = 0; i < n; i++) {
                bStr = "0".concat(bStr);
            }
        } else {
            int n = bStr.length() - aStr.length();
            for (int i = 0; i < n; i++) {
                aStr = "0".concat(aStr);
            }
        }

        int n = aStr.length();
        if (n == 1) {
            return a * b;
        }

        int center = n/2;
        if (n % 2 == 1) {
            center++;
        }

        int aLeft = Integer.parseInt(aStr.substring(0, center));
        int bLeft = Integer.parseInt(bStr.substring(0, center));
        int aRight = Integer.parseInt(aStr.substring(center));
        int bRight = Integer.parseInt(bStr.substring(center));

        int left = karatsuba(aLeft, bLeft);
        int right = karatsuba(aRight, bRight);
        int middle = karatsuba(aLeft + aRight, bLeft + bRight);
        return merge(left, middle - left - right, right, n/2);
    }

    private int merge(int left, int middle, int right, int n) {
        int pow = (int)Math.pow(10, n);
        return left*pow*pow + middle*pow + right;
    }
}
