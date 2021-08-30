package com.pipi.firstdemo.likou.二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的前序遍历 extends  Object{
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }


    private void inorder(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        inorder(root.left);
        inorder(root.right);
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
