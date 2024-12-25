package org.example.module10;

import org.example.IModule;

public class Module10_5 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {},
        };
    }

    @Override
    public void execute(Object[][] data) {
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recursiveHasPathSum(root, targetSum, 0);
    }

    private boolean recursiveHasPathSum(TreeNode root, int targetSum, int currentSum) {
        if (null == root) {
            return false;
        }

        currentSum += root.val;
        if (null == root.left && null == root.right) {
            if (currentSum == targetSum) {
                return true;
            }
        } else {
            boolean left = recursiveHasPathSum(root.left, targetSum, currentSum);
            boolean right = recursiveHasPathSum(root.right, targetSum, currentSum);
            return left || right;
        }
        return false;
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
