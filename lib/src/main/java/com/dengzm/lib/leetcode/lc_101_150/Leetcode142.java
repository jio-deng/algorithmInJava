package com.dengzm.lib.leetcode.lc_101_150;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 环形链表 II
 * @date 2020/2/7 20:21
 */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        int times = 0;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast == slow) {
                if (times == 0) {
                    times ++;
                } else {
                    break;
                }
            }

            if (fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) {
            return null;
        }

        ListNode pre = head;
        while (pre != slow) {
            pre = pre.next;
            slow = slow.next;
        }

        return pre;
    }

    /**
     * 网上大神写法 很简洁
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
