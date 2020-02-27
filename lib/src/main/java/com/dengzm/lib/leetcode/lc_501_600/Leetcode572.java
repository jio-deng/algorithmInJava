package com.dengzm.lib.leetcode.lc_501_600;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 另一个树的子树
 * @date 2020/2/23 17:52
 */
public class Leetcode572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        }
        return checkTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean checkTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }

        return checkTree(s.left, t.left) && checkTree(s.right, t.right);
    }
}
