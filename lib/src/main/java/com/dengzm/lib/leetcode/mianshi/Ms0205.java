package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 02.05. 链表求和
 * @date 2020/4/6 11:38
 */
public class Ms0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int extra = 0;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + extra;
            extra = val / 10;
            val %= 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode node = l1 != null ? l1 : l2;
        while (node != null || extra != 0) {
            int val = (node != null ? node.val : 0) + extra;
            extra = val / 10;
            val %= 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            if (node != null) {
                node = node.next;
            }
        }

        return dummy.next;
    }
}
