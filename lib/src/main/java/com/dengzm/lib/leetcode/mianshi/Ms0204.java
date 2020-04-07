package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 02.04. 分割链表
 * @date 2020/4/7 19:37
 */
public class Ms0204 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode dummy3 = new ListNode(0);

        ListNode node1 = dummy1, node2 = dummy2, node3 = dummy3;

        while (head != null) {
            if (head.val < x) {
                node1.next = new ListNode(head.val);
                node1 = node1.next;
            } else if (head.val > x) {
                node3.next = new ListNode(head.val);
                node3 = node3.next;
            } else {
                node2.next = new ListNode(head.val);
                node2 = node2.next;
            }

            head = head.next;
        }

        ListNode dummy4 = new ListNode(0);
        ListNode ans = dummy4;
        ans.next = dummy1.next;
        if (node1 != dummy1) {
            ans = node1;
        }

        ans.next = dummy2.next;
        if (node2 != dummy2) {
            ans = node2;
        }

        ans.next = dummy3.next;
        return dummy4.next;
    }
}
