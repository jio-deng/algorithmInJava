package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 简单 面试题52. 两个链表的第一个公共节点
 * @date 2020/6/11 10:47
 */
public class Ms052 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode node = headA;
        while (node != null) {
            lengthA ++;
            node = node.next;
        }

        node = headB;
        while (node != null) {
            lengthB ++;
            node = node.next;
        }

        int n = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            while (n > 0) {
                headA = headA.next;
                n --;
            }
        } else if (lengthB > lengthA) {
            while (n > 0) {
                headB = headB.next;
                n --;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;
    }
}
