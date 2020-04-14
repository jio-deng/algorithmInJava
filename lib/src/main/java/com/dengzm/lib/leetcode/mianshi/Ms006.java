package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题06. 从尾到头打印链表
 * @date 2020/4/14 12:37
 */
public class Ms006 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        if (list.size() == 0) {
            return new int[] {};
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i ++) {
            ans[i] = list.get(list.size() - 1 - i);
        }

        return ans;
    }
}
