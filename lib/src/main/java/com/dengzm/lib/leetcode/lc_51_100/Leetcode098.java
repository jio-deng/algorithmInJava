package com.dengzm.lib.leetcode.lc_51_100;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 验证二叉搜索树
 * @date 2020/2/1 9:58
 */
public class Leetcode098 {
    private static final long MIN = Long.MIN_VALUE;
    private static final long MAX = Long.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isVaildBSTCore(root.left, MIN, root.val) && isVaildBSTCore(root.right, root.val, MAX);
    }

    private boolean isVaildBSTCore(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val >= max || root.val <= min) {
            return false;
        }

        return isVaildBSTCore(root.left, min, root.val) && isVaildBSTCore(root.right, root.val, max);
    }
}
