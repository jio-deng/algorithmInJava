package com.dengzm.lib.leetcode.lc_901_1000;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 单值二叉树
 * @date 2020/3/19 9:02
 */
public class Leetcode965 {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeCore(root, root.val);
    }

    private boolean isUnivalTreeCore(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        return root.val == val && isUnivalTreeCore(root.left, val) && isUnivalTreeCore(root.right, val);
    }
}
