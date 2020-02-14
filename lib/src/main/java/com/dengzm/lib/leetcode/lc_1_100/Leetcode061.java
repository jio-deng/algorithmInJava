package com.dengzm.lib.leetcode.lc_1_100;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 旋转链表
 * @date 2020/1/25 10:57
 */
public class Leetcode061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length ++;
        }

        int moveStep = length - k % length;
        if (moveStep == 0) {
            return head;
        }

        tail.next = head;
        for (int i = 0; i < moveStep; i ++) {
            tail = tail.next;
        }

        ListNode result = tail.next;
        tail.next = null;

        return result;
    }
}
