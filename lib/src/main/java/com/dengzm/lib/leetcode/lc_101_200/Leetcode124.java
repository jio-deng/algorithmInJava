package com.dengzm.lib.leetcode.lc_101_200;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树中的最大路径和
 * @date 2020/2/27 10:33
 */
public class Leetcode124 {
    int max = -10000000;

    public int maxPathSum(TreeNode root) {
        maxPathSumCore(root);
        return max;
    }

    private int maxPathSumCore(TreeNode root) {
        if (root == null) {
            return -10000000;
        }

        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return root.val;
        }

        int left = maxPathSumCore(root.left);
        int right = maxPathSumCore(root.right);

        //System.out.println(left + ", " + right);

        if (root.val < 0) {
            max = Math.max(max, Math.max(Math.max(Math.max(left, right), root.val), left + root.val + right));
        } else {
            max = Math.max(max, (left >= 0 ? left : 0) + (right >= 0 ? right : 0) + root.val);
        }

        //System.out.println("root.val = " + root.val + ", " + (Math.max(left, right) > 0 ? Math.max(left, right) : 0));

        return root.val + (Math.max(left, right) > 0 ? Math.max(left, right) : 0);
    }
}
