package org.example.module10;

import org.example.IModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Module10_1 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {},
        };
    }

    @Override
    public void execute(Object[][] data) {
    }

    public List<Integer> rightSideView(TreeNode root) {

        Map<Integer, Integer> lvlVal = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        fun(root, 0, lvlVal);

        for (Integer key: lvlVal.keySet().stream().sorted().collect(Collectors.toList())) {
            result.add(lvlVal.get(key));
            System.out.println(key + ":" + lvlVal.get(key));
        }
        return result;
    }

    public void fun(TreeNode current, int level, Map<Integer, Integer> lvlVal) {

        if (null == current) {
            return;
        }

        Integer seen = lvlVal.get(level);

        if (null == seen) {
            lvlVal.put(level, current.val);
        }

        fun(current.right, level + 1, lvlVal);
        fun(current.left, level + 1, lvlVal);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
