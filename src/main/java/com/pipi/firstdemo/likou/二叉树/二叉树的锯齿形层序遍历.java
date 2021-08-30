package com.pipi.firstdemo.likou.二叉树;

import java.util.*;

public class 二叉树的锯齿形层序遍历 {
    static Map<Integer, Object> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n20.left = n15;
        n20.right = n7;
        n3.left = n9;
        n3.right = n20;
        n9.left = n1;
        n9.right = n2;
        List<List<Integer>> lists = zigzagLevelOrder(n3);
        System.out.println(123);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;

    }

    private static List<Integer> stackToList(Stack<Integer> stack) {
        List<Integer> list = new ArrayList<>();
        int i;
        while (true) {
            Integer pop = null;
            try {
                pop = stack.pop();
            } catch (Exception e) {
                break;
            }
            list.add(pop);
        }
        return list;
    }

    private static void inorders(TreeNode root, int level) {
        if (root == null) return;
        //使用栈
        if (level % 2 == 0) {
            if (map.get(level) == null) {
                Stack<Integer> stack = new Stack<>();
                stack.push(root.val);
                map.put(level, stack);
            } else {
                ((Stack<Integer>) map.get(level)).push(root.val);
            }
        } else {
            if (map.get(level) == null) {
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(root.val);
                map.put(level, objects);
            } else {
                ((ArrayList<Integer>) map.get(level)).add(root.val);
            }
        }
        inorders(root.left, level + 1);
        inorders(root.right, level + 1);
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
