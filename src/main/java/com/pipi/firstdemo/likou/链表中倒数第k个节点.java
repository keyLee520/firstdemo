package com.pipi.firstdemo.likou;

public class 链表中倒数第k个节点 {
    int i = 0;
    ListNode node = null;

    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode kthFromEnd = getKthFromEnd(head.next, k);
        if (++i == k) return head;
        return null;
    }


    private void findNode(ListNode head, int k) {
        if (head == null) return;
        findNode(head.next, k);
        if (++i == k) {
            node = head;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
