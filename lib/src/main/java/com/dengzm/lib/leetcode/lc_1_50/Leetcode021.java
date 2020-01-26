package com.dengzm.lib.leetcode.lc_1_50;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 合并两个有序链表
 * @date 2019/12/30 10:22
 */
public class Leetcode021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while (l1 != null && l2 != null) {
            dummy.next = l1.val <= l2.val ? l1 : l2;
            if (l1.val <= l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }

            dummy = dummy.next;
        }

        if (l1 != null) {
            dummy.next = l1;
        } else if (l2 != null) {
            dummy.next = l2;
        }

        return result.next;
    }

    /*执行结果：通过
      显示详情
      执行用时 :1 ms, 在所有 java 提交中击败了81.25%的用户
      内存消耗 :38.7 MB, 在所有 java 提交中击败了70.89%的用户*/
}
