package org.example.module11;

import org.example.IModule;

import java.util.HashMap;
import java.util.Map;

public class Module11_1 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {"egg", "add", true},
                new Object[] {"foo", "bar", false},
                new Object[] {"paper", "title", true},
                new Object[] {"badc", "baba", false},
        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            boolean actual = isIsomorphic((String)data[i][0], (String)data[i][1]);
            System.out.println("expected: " + (boolean)data[i][2]);
            System.out.println("actual: " + actual);
        }
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
