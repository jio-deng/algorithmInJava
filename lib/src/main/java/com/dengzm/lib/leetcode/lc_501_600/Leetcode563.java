package com.dengzm.lib.leetcode.lc_501_600;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的坡度
 * @date 2020/2/22 21:28
 */
public class Leetcode563 {

    int ans = 0;
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        sum(root);

        return ans;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);

        ans += Math.abs(left - right);

        return left + right + root.val;
    }
}
