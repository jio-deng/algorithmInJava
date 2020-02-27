package com.dengzm.lib.leetcode.lc_601_700;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 合并二叉树
 * @date 2020/2/26 18:51
 */
public class Leetcode617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode root = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return root;
    }
}
