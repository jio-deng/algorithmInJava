package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题18. 删除链表的节点
 * @date 2020/4/14 12:54
 */
public class Ms018 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                if (pre == null) {
                    head = head.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
