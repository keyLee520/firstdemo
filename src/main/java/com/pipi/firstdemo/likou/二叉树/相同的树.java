package com.pipi.firstdemo.likou.二叉树;

public class 相同的树 {


    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return p != null && q != null ? p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right) : p == q;
    }


    private boolean equalss(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) return false;
        return p.val == q.val && equalss(p.left, q.left) && equalss(p.right, q.right);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
