package com.dengzm.lib.leetcode.lc_201_300;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 移除链表元素
 * @date 2020/2/13 13:12
 */
public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, node = dummy.next;
        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
            } else {
                pre = pre.next;
            }

            node = node.next;
        }

        return dummy.next;
    }
}
