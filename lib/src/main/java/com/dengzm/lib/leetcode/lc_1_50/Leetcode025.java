package com.dengzm.lib.leetcode.lc_1_50;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description K 个一组翻转链表
 * @date 2020/1/1 9:18
 */
public class Leetcode025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }


        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        ListNode[] allNodes = new ListNode[k];

        while (temp != null) {
            ListNode cur = temp;
            for (int i = 0; i < k; i ++) {
                if (temp.next != null) {
                    temp = temp.next;
                    allNodes[i] = temp;
                } else {
                    return dummy.next;
                }
            }

            ListNode rest = temp.next;
            temp = cur;

            for (int i = k - 1; i >= 0; i --) {
                temp.next = allNodes[i];
                temp = temp.next;
            }

            temp.next = rest;
        }

        return dummy.next;
    }

    /*执行结果：通过
      显示详情
      执行用时 :1 ms, 在所有 java 提交中击败了78.94%的用户
      内存消耗 :38.6 MB, 在所有 java 提交中击败了77.11%的用户*/

    public static void main(String[] args) {
        Leetcode025 leetcode025 = new Leetcode025();
        ListNode data = new ListNode(1);
        data.next = new ListNode(2);
        data.next.next = new ListNode(3);
        data.next.next.next = new ListNode(4);
        data.next.next.next.next = new ListNode(5);
        int k = 2;
        leetcode025.reverseKGroup(data, k);
    }
}
