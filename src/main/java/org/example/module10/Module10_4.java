package org.example.module10;

import org.example.IModule;

public class Module10_4 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {},
        };
    }

    @Override
    public void execute(Object[][] data) {
    }

    private int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        doMagic(root);
        return result;
    }

    private int doMagic(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = Math.max(doMagic(root.left), 0);
        int right = Math.max(doMagic(root.right), 0);
        result = Math.max(result, root.val + left + right);
        return root.val + Math.max(left, right);
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
