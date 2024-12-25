package org.example.module11;

import org.example.IModule;

import java.util.*;

public class Module11_2 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {new int[]{1,3,5,7,9}, 4},
                new Object[] {new int[]{1,1,1,3,3,3,7}, 15},
                new Object[] {new int[]{149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234}, 12},
                new Object[] {new int[]{1048576,1048576}, 1},
        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            int actual = countPairs((int[])data[i][0]);
            System.out.println("expected: " + (int)data[i][1]);
            System.out.println("actual: " + actual);
        }
    }

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            map.putIfAbsent(deliciousness[i], 0);
            map.replace(deliciousness[i], map.get(deliciousness[i]) + 1);
        }
        List<Integer> powers = new ArrayList<>();
        powers.add(1);
        for (int i = 1; i < 22; i++) {
            powers.add(powers.get(i - 1) << 1);
        }
        long counter = 0;
        for (int i = 0; i < powers.size(); i++) {
            for (int j = 0; j < deliciousness.length; j++) {
                int y = powers.get(i) - deliciousness[j];

                if (map.containsKey(y) && map.get(y) > 0 && (null == pairs.get(deliciousness[j]) || !pairs.get(deliciousness[j]).equals(y))) {
                    if (deliciousness[j] == y) {
                        counter += ((long) map.get(y) * (map.get(y) - 1)) / 2;
                    } else {
                        counter += (long) map.get(deliciousness[j]) * map.get(y);
                    }
                    pairs.put(deliciousness[j], y);
                    pairs.put(y, deliciousness[j]);
                }
            }
        }

        return (int)(counter % 1000000007);
    }
}
