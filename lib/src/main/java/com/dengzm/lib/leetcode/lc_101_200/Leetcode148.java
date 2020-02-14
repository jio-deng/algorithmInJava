package com.dengzm.lib.leetcode.lc_101_200;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @Description 排序链表
 * Created by deng on 2020/2/8.
 */
public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        ListNode dummy = new ListNode(0);
        ListNode d = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                d.next = left;
                left = left.next;
            } else {
                d.next = right;
                right = right.next;
            }

            d= d.next;
        }

        d.next = left != null ? left : right;

        return dummy.next;
    }
}
