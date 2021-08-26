package com.pipi.firstdemo.likou;


import javax.swing.tree.TreeNode;

public class 删除二叉搜索树中的节点 {
    /**
     * 4
     * 2   6
     * 5  7
     */
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        node6.left = node5;
        node6.right = node7;
        node4.right = node6;
        node4.left = node2;
      /*  TreeNode node = deleteNode(node4,6);
        System.out.println(123);*/
        successor(node6);
        System.out.println(123);

    }

    /**
     * 4
     * 2   6
     * 5  7
     */
    public static int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
    One step left and then always right
    */
    public static int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    /**
     * 后继节点
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }


    static class TreeNode {
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
