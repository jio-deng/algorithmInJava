package com.dengzm.lib.leetcode.lc_101_200;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的最大深度
 * @date 2020/2/1 10:37
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        return maxDepthCore(root);
    }

    private int maxDepthCore(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepthCore(root.left), maxDepthCore(root.right));
    }
}
