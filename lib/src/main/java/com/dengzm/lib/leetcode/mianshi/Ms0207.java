package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 02.07. 链表相交
 * @date 2020/4/6 11:00
 */
public class Ms0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = 0, lengthB = 0;
        ListNode tmp = headA;
        while (tmp != null) {
            tmp = tmp.next;
            lengthA ++;
        }

        tmp = headB;
        while (tmp != null) {
            tmp = tmp.next;
            lengthB ++;
        }

        int dif = Math.abs(lengthA - lengthB);
        ListNode node = lengthA > lengthB ? headA : headB;
        while (dif > 0) {
            node = node.next;
            dif --;
        }

        ListNode another = lengthA > lengthB ? headB : headA;
        while (node != null && another != null) {
            if (node == another) {
                return node;
            }

            node = node.next;
            another = another.next;
        }

        return null;
    }
}
