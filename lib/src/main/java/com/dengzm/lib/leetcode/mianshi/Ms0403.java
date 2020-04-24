package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.ListNode;
import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 04.03. 特定深度节点链表
 * @date 2020/4/21 12:34
 */
public class Ms0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[] {};
        }

        List<ListNode> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(0), head = dummy;
            while (size > 0) {
                TreeNode node = queue.poll();
                head.next = new ListNode(node.val);
                head = head.next;
                size --;
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            list.add(dummy.next);
        }

        ListNode[] ans = new ListNode[list.size()];
        for (int i = 0; i < ans.length; i ++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
