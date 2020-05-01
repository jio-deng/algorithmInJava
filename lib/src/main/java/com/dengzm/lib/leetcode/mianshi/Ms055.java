package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题55 - I. 二叉树的深度 && 面试题55 - II. 平衡二叉树
 * @date 2020/4/28 11:16
 */
public class Ms055 {
    public int maxDepth(TreeNode root) {
        int ans = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            ans ++;
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                size --;
            }
        }

        return ans;
    }

    private boolean isBanlanced = true;
    public boolean isBalanced(TreeNode root) {
        depthCore(root);
        return isBanlanced;
    }

    private int depthCore(TreeNode node) {
        if (!isBanlanced) {
            return 0;
        }

        if (node == null) {
            return 0;
        }

        int left = depthCore(node.left);
        int right = depthCore(node.right);
        if (Math.abs(left - right) > 1) {
            isBanlanced = false;
        }

        return Math.max(left, right) + 1;
    }
}
