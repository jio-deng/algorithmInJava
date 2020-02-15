package com.dengzm.lib.leetcode.lc_401_500;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 左叶子之和
 * @date 2020/2/15 19:50
 */
public class Leetcode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sumOfLeftLeavesCore(root, false);
    }

    private int sumOfLeftLeavesCore(TreeNode root, boolean isLeft) {
        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }

        int result = 0;
        if (root.left != null) {
            result += sumOfLeftLeavesCore(root.left, true);
        }

        if (root.right != null) {
            result += sumOfLeftLeavesCore(root.right, false);
        }

        return result;
    }
}
