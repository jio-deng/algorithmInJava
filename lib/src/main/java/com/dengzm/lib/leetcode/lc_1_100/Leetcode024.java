package com.dengzm.lib.leetcode.lc_1_100;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两两交换链表中的节点
 * @date 2020/1/1 9:05
 */
public class Leetcode024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;

        while (temp.next != null && temp.next.next != null) {
            ListNode a = temp.next;
            ListNode b = a.next;
            temp.next = b;
            a.next = b.next;
            b.next = a;
            temp = a;
        }

        return dummy.next;
    }

    /*执行结果：通过
      显示详情
      执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
      内存消耗 :34.6 MB, 在所有 java 提交中击败了81.91%的用户*/
}
