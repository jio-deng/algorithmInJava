package com.dengzm.lib.leetcode.lc_101_150;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @Description 重排链表
 * Created by deng on 2020/2/8.
 */
public class Leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast.next == null || fast.next.next == null) {
                break;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        second = reverseList(second);

        while (head != null && second != null) {
            ListNode insert = second;
            second = second.next;

            ListNode temp = head.next;
            head.next = insert;
            insert.next = temp;

            head = temp;

            if (temp == null) {
                insert.next = second;
            }
        }

    }

    private ListNode reverseList(ListNode head) {
        ListNode pre, cur = null;
        while (head != null) {
            pre = cur;
            cur = head;
            head = head.next;
            cur.next = pre;
        }

        return cur;
    }
}
