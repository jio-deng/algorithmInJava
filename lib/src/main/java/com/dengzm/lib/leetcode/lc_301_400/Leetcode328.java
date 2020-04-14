package com.dengzm.lib.leetcode.lc_301_400;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 奇偶链表
 * @date 2020/4/14 10:19
 */
public class Leetcode328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head, even = head.next, curEven = even;
        while (curEven != null && curEven .next != null) {
            odd.next = curEven.next;
            curEven.next = curEven.next.next;
            odd.next.next = even;

            curEven = curEven.next;
            odd = odd.next;
        }

        return head;
    }
}
