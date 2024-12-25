package org.example.module10;

import org.example.IModule;

public class Module10_2 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {},
        };
    }

    @Override
    public void execute(Object[][] data) {
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode parent = new TreeNode();

        if (null != root1 && null != root2) {
            parent.val = root1.val + root2.val;
            parent.left = mergeTrees(root1.left, root2.left);
            parent.right = mergeTrees(root1.right, root2.right);
        } else if (null == root1 && null != root2) {
            parent.val = root2.val;
            parent.left = mergeTrees(root1, root2.left);
            parent.right = mergeTrees(root1, root2.right);
        } else if (null != root1 && null == root2) {
            parent.val = root1.val;
            parent.left = mergeTrees(root1.left, root2);
            parent.right = mergeTrees(root1.right, root2);
        } else {
            return null;
        }

        return parent;
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
