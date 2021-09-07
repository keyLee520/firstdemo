package com.pipi.firstdemo.likou;

import java.util.*;


//         5
//    1        4
//  null null 3  6
//
public class 验证二叉搜索树 {
    static List<Integer> list = new ArrayList();
    static boolean res = true;

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        n5.left = n1;
        n5.right = n4;
        n4.left = n3;
        n4.right = n6;
        System.out.println(isValidBST(n5));
    }
//         5
//      1      4
//  null null 3  6
//
    public static boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


    private static void search(TreeNode root) {
        if (root == null) return;
        search(root.left);
        if (list.size() != 0) {
            if (list.get(0) > root.val) res = false;
        }
        list.add(0, root.val);
        search(root.right);
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
