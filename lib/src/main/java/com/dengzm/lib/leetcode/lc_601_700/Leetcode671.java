package com.dengzm.lib.leetcode.lc_601_700;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树中第二小的节点
 * @date 2020/2/29 11:29
 */
public class Leetcode671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int min = root.val;
        boolean isSecShow = false;
        int secMin = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == min) {
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            } else if (node.val > min) {
                if (!isSecShow || node.val < secMin) {
                    secMin = node.val;
                    isSecShow = true;
                }
            }
        }

        return isSecShow ? secMin : -1;
    }
}
