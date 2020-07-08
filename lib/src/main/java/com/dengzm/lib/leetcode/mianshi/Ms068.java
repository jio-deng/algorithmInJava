package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 *              剑指 Offer 68 - II. 二叉树的最近公共祖先
 * @date 2020/6/24 8:19
 */
public class Ms068 {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        return lowestCommonAncestorCore(root, p, q);
    }

    private TreeNode lowestCommonAncestorCore(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode n1 = lowestCommonAncestorCore(root.left, p, q);
        TreeNode n2 = lowestCommonAncestorCore(root.right, p, q);

        if (n1 == null && n2 == null) {
            return null;
        } else if (n1 != null && n2 != null) {
            return root;
        } else if (n1 != null) {
            return n1;
        } else {
            return n2;
        }
    }
}
