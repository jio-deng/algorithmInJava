package com.dengzm.lib.leetcode.lc_51_100;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 分隔链表
 * @date 2020/1/29 21:41
 */
public class Leetcode086 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // 哑节点
        ListNode upper = new ListNode(0);
        ListNode upperHead = upper;
        ListNode downer = new ListNode(0);
        ListNode downerCore = downer;

        while (head != null) {
            if (head.val < x) {
                upper.next = head;
                head = head.next;
                upper = upper.next;
                upper.next = null;
            } else {
                downer.next = head;
                head = head.next;
                downer = downer.next;
                downer.next = null;
            }
        }

        upper.next = downerCore.next;
        return upperHead.next;
    }
}
