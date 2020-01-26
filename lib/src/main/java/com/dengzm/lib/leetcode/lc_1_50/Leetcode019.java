package com.dengzm.lib.leetcode.lc_1_50;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 删除链表的倒数第N个节点
 * @date 2019/12/29 9:31
 */
public class Leetcode019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i < n + 1; i ++) {
            if (first != null) {
                first = first.next;
            }
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    /*执行结果：通过
      显示详情
      执行用时 :1 ms, 在所有 java 提交中击败了46.34%的用户
      内存消耗 :35 MB, 在所有 java 提交中击败了86.60%的用户*/
}
