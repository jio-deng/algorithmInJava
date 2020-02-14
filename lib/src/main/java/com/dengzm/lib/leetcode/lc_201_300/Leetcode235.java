package com.dengzm.lib.leetcode.lc_201_300;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉搜索树的最近公共祖先
 * @date 2020/2/14 10:30
 */
public class Leetcode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > max) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
