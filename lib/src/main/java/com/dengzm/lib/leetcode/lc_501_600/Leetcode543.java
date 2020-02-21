package com.dengzm.lib.leetcode.lc_501_600;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的直径
 * @date 2020/2/21 17:05
 */
public class Leetcode543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        diameterOfBinaryTreeCore(root);
        return max;
    }

    private int diameterOfBinaryTreeCore(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = diameterOfBinaryTreeCore(root.left);
        int right = diameterOfBinaryTreeCore(root.right);
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
