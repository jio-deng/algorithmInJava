package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 02.02. 返回倒数第 k 个节点
 * @date 2020/4/4 10:31
 */
public class Ms0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k --;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;
    }
}
