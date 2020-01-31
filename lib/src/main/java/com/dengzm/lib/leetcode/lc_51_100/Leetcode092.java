package com.dengzm.lib.leetcode.lc_51_100;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 反转链表 II
 * @date 2020/1/31 10:05
 */
public class Leetcode092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m > n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        for (int i = 0; i < m - 1; i ++) {
            first = first.next;
        }

        ListNode pre = null, tail = null;
        ListNode cur = first.next;

        for (int i = 0; i < n - m + 1; i ++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            if (tail == null) {
                tail = pre;
            }
            cur = temp;
        }

        first.next = pre;
        tail.next = cur;

        return dummy.next;
    }
}
