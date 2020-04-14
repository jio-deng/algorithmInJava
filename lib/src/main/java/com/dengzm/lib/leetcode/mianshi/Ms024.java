package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题24. 反转链表
 * @date 2020/4/14 12:51
 */
public class Ms024 {
    public ListNode reverseList(ListNode head) {
        ListNode ans = null, tmp;
        while (head != null) {
            tmp = head;
            head = head.next;
            tmp.next = ans;
            ans = tmp;
        }

        return ans;
    }
}
