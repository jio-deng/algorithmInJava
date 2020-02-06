package com.dengzm.lib.leetcode.lc_101_150;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的最小深度
 * @date 2020/2/6 10:34
 */
public class Leetcode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null || root.right == null) {
            return minDepth(root.left) + minDepth(root.right) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
