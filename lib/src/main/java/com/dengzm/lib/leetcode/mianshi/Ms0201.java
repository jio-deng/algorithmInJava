package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 02.01. 移除重复节点
 * @date 2020/4/4 10:28
 */
public class Ms0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head.val)) {
                cur.next = new ListNode(head.val);
                set.add(head.val);
                cur = cur.next;
            }

            head = head.next;
        }

        return dummy.next;
    }
}
