package com.pipi.firstdemo.likou.二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {

    public class TreeNode {
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

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return inorder(root, res);
    }

    private List<Integer> inorder(TreeNode root, List<Integer> res) {
        if (root == null) return res;
        res = inorder(root.left, res);
        res.add(root.val);
        res = inorder(root.right, res);
        return res;
    }
}
