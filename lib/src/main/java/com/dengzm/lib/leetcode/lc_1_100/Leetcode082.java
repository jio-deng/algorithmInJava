package com.dengzm.lib.leetcode.lc_1_100;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 删除排序链表中的重复元素 II
 * @date 2020/1/29 10:50
 */
public class Leetcode082 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;
        ListNode pre = null;

        while (first != null && first.next != null) {
            if (first.next.val == first.val) {
                ListNode temp = first.next;
                while (temp.next != null && temp.next.val == first.val) {
                    temp = temp.next;
                }

                if (pre == null) {
                    head = first = temp.next;
                } else {
                    pre.next = first = temp.next;
                }
            } else {
                pre = first;
                first = first.next;
            }
        }

        return head;
    }
}
