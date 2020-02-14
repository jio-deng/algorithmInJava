package com.dengzm.lib.leetcode.lc_201_300;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 删除链表中的节点 (删除当前节点，当前节点非尾节点)
 * @date 2020/1/1 9:45
 */
public class Leetcode237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /*执行结果：通过
      显示详情
      执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
      内存消耗 :36.4 MB, 在所有 java 提交中击败了54.93%的用户*/
}
