package org.example.module1;

import org.example.IModule;

import java.util.Arrays;

public class Module1 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {10, new int[] {5, 2, 1}, 3, new int[] {2, 0, 0}},
                new Object[] {77, new int[] {25, 10, 5, 1}, 4, new int[] {3, 0, 0, 2}},
                new Object[] {40, new int[] {25, 20, 10, 5, 1}, 5, new int[] {0, 2, 0, 0, 0}},
                new Object[] {3, new int[] {25, 20, 10, 5, 1}, 5, new int[] {0, 0, 0, 0, 3}},
                new Object[] {6, new int[] {25, 20, 10, 5, 1}, 5, new int[] {0, 0, 0, 1, 1}},
                new Object[] {133, new int[] {25, 20, 10, 5, 1}, 5, new int[] {5, 0, 0, 1, 3}},
//                new Object[] {133, new int[] {25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 25, new int[] { /* 5*25+1*8, если убрать 8, 7*19, если убрать 19, 5*25+1*7+1*1 */ }},
                new Object[] {65, new int[] {25, 20, 1}, 3, new int[] { 1, 2, 0 }},
        };
    }
    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            int[] actual = bruteForce((int)data[i][0], (int[])data[i][1]);
            System.out.println("expected: " + Arrays.toString((int[])data[i][3]));
            System.out.println("actual: " + Arrays.toString(actual));
        }
    }

    private int[] bruteForce(int money, int[] coins) {
        int[] combination = new int[coins.length];
        return recursiveCombinations(combination, 0, money, coins);
    }

    private int[] recursiveCombinations(int[] combination, int index, int money, int[] coins) {
        int[] result = new int[coins.length];
        int[] newResult = new int[coins.length];

        if (index == combination.length) {
            if (calculateValue(combination, coins) != money) {
                return result;
            }
            return combination;
        }

        int smallestNumberOfCoins = calculateNumberOfCoins(result);
        for (int i = 0; i <= money/coins[index]; i++) {
            combination[index] = i;
            newResult = recursiveCombinations(combination, index + 1, money, coins);
            int numberOfCoins = calculateNumberOfCoins(newResult);
            if (smallestNumberOfCoins == 0 || (numberOfCoins < smallestNumberOfCoins && numberOfCoins != 0)) {
                smallestNumberOfCoins = numberOfCoins;
                result = newResult.clone();
            }
        }

        return result;
    }

    private int calculateNumberOfCoins(int[] combination) {
        int numberOfCoins = 0;
        for (int k = 0; k < combination.length; k++) {
            numberOfCoins += combination[k];
        }
        return numberOfCoins;
    }

    private int calculateValue(int[] combination, int[] coins) {
        int value = 0;
        for (int k = 0; k < coins.length; k++) {
            value += coins[k] * combination[k];
        }
        return value;
    }

}
