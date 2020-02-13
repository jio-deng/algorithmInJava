package com.dengzm.lib.leetcode.lc_151_200;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 相交链表
 * @date 2020/2/13 9:40
 */
public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // calculate length
        int aLength = 0, bLength = 0;
        ListNode temp = headA;
        while (temp != null) {
            temp = temp.next;
            aLength ++;
        }

        temp = headB;
        while (temp != null) {
            temp = temp.next;
            bLength ++;
        }

        int longer = aLength > bLength ? aLength : bLength;
        int shorter = aLength > bLength ? bLength : aLength;
        int dif = longer - shorter;

        ListNode l = aLength > bLength ? headA : headB;
        ListNode s = aLength > bLength ? headB : headA;

        while (dif > 0) {
            l = l.next;
            dif --;
        }

        while (l != null && s != null) {
            if (l == s) {
                return l;
            }

            l = l.next;
            s = s.next;
        }

        return null;
    }
}
