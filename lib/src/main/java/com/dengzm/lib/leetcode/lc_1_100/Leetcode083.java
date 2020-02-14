package com.dengzm.lib.leetcode.lc_1_100;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 删除排序链表中的重复元素
 * @date 2020/1/29 10:46
 */
public class Leetcode083 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;

        while (first != null && first.next != null) {
            if (first.next.val == first.val) {
                first.next = first.next.next;
            } else {
                first = first.next;
            }
        }

        return head;
    }
}
