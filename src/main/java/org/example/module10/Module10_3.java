package org.example.module10;

import org.example.IModule;

public class Module10_3 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {},
        };
    }

    @Override
    public void execute(Object[][] data) {
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val <= val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
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
