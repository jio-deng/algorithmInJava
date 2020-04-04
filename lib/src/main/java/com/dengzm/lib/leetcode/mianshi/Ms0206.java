package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 02.06. 回文链表
 * @date 2020/4/4 10:34
 */
public class Ms0206 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder("#");
        while (head != null) {
            sb.append(head.val);
            sb.append("#");
            head = head.next;
        }

        int start = 1, end = sb.length() - 2;
        StringBuilder s1;
        StringBuilder e1;
        while (start < end) {
            s1 = new StringBuilder();
            e1 = new StringBuilder();
            while (start < sb.length() - 1 && sb.charAt(start) != '#') {
                s1.append(sb.charAt(start));
                start ++;
            }

            while (0 < end && sb.charAt(end) != '#') {
                e1.append(sb.charAt(end));
                end --;
            }

            if (!s1.toString().contentEquals(e1.reverse())) {
                return false;
            }

            start ++;
            end --;
        }

        return true;
    }
}
