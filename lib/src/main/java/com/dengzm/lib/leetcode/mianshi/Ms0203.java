package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 02.03. 删除中间节点
 * @date 2020/2/21 16:01
 */
public class Ms0203 {
    public void deleteNode(ListNode node, int n) {
        while(node.val != n) {
            node = node.next;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
