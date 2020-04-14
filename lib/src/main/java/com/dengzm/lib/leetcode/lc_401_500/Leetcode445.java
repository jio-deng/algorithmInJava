package com.dengzm.lib.leetcode.lc_401_500;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两数相加 II
 * @date 2020/4/14 9:26
 */
public class Leetcode445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int extra = 0;
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + extra;
            extra = val / 10;
            val %= 10;
            ans.next = new ListNode(val);
            ans = ans.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l = l1 == null ? l2 : l1;
        while (l != null || extra != 0) {
            int val = (l == null ? 0 : l.val) + extra;
            extra = val / 10;
            val %= 10;
            ans.next = new ListNode(val);
            ans = ans.next;

            if (l != null) {
                l = l.next;
            }
        }

        ans = dummy.next;
        return reverse(ans);
    }

    private ListNode reverse(ListNode node) {
        ListNode res = null;
        ListNode tmp = null;
        while (node != null) {
            tmp = node;
            node = node.next;
            tmp.next = res;
            res = tmp;
        }

        return res;
    }
}
