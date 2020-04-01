package com.dengzm.lib.leetcode.lc_1201_1300;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二进制链表转整数
 * @date 2020/3/21 11:03
 */
public class Leetcode1290 {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans <<= 1;
            ans += head.val;
            head = head.next;
        }

        return ans;
    }
}
