package com.dengzm.lib.leetcode.lc_301_400;

import com.dengzm.lib.leetcode.lc.ListNode;

import java.util.Random;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 链表随机节点
 * @date 2020/3/2 12:07
 */
public class Leetcode382 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        ListNode head;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            ListNode p = head;
            ListNode r = null;

            int cnt = 0;
            while (p != null) {
                if (cnt ++ == 0) {
                    r = p;
                } else {
                    int t = new Random().nextInt() % cnt;
                    if (t == 0) {
                        r = p;
                    }
                }

                p = p.next;
            }

            return r.val;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
}
