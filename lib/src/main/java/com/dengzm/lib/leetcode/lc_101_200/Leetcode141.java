package com.dengzm.lib.leetcode.lc_101_200;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 环形链表
 * @date 2020/2/7 20:15
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            }

            fast = fast.next;
        }

        return false;
    }
}
