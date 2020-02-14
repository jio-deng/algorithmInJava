package com.dengzm.lib.leetcode.lc_1_100;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 相同的树
 * @date 2020/2/1 10:07
 */
public class Leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeCore(p, q);
    }

    private boolean isSameTreeCore(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTreeCore(p.left, q.left) && isSameTreeCore(p.right, q.right);
    }
}
