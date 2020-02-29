package com.dengzm.lib.leetcode.lc_601_700;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 修剪二叉搜索树
 * @date 2020/2/29 11:23
 */
public class Leetcode669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
