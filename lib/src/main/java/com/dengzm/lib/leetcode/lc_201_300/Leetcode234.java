package com.dengzm.lib.leetcode.lc_201_300;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 回文链表
 * @date 2020/2/14 10:05
 */
public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        ListNode shorter = slow;
        shorter = reverse(shorter);

        while (shorter != null) {
            if (shorter.val != head.val) {
                return false;
            }

            shorter = shorter.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Leetcode234 leetcode234 = new Leetcode234();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        System.out.println(leetcode234.isPalindrome(node1));
    }

}
