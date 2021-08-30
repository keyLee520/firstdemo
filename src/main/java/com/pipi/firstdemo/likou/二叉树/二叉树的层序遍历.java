package com.pipi.firstdemo.likou.二叉树;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 二叉树的层序遍历 {
    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n20.left = n15;
        n20.right = n7;
        n3.left = n9;
        n3.right = n20;
        levelOrder(n3);
        System.out.println(123);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        inorder(root, 1);
        List<List<Integer>> list = new ArrayList<>();
        int i = 1;
        while (map.get(i) != null) {
            list.add(map.get(i));
            i++;
        }
        return list;
    }

    private static void inorder(TreeNode root, int level) {
        if (root == null) return;
        if (map.get(level) == null) {
            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(root.val);
            map.put(level, objects);
        } else {
            map.get(level).add(root.val);
        }

        inorder(root.left, level + 1);
        inorder(root.right, level + 1);
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
