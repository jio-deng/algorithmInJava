package com.dengzm.lib.leetcode.lc_101_200;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @Description 对链表进行插入排序
 * Created by deng on 2020/2/8.
 */
public class Leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head;

        ListNode rest = head.next;
        head.next = null;

        while (rest != null) {
            ListNode node = rest;
            rest = rest.next;
            node.next = null;

            if (node.val >= tail.val) {
                tail.next = node;
                tail = tail.next;
                continue;
            }

            ListNode cur = dummy;
            while (cur.next != null && cur.next.val < node.val) {
                cur = cur.next;
            }

            node.next = cur.next;
            cur.next = node;
        }

        return dummy.next;
    }
}
