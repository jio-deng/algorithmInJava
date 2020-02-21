package com.dengzm.lib.leetcode.lc_501_600;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 把二叉搜索树转换为累加树
 * @date 2020/2/21 16:35
 */
public class Leetcode538 {
    public TreeNode convertBST(TreeNode root) {
        convertBSTCore(root, 0);
        return root;
    }

    public int convertBSTCore(TreeNode root, int val) {
        if (root == null) {
            return val;
        }

        int right = convertBSTCore(root.right, val);
        root.val += right;
        int left = convertBSTCore(root.left, root.val);

        return left;
    }
}
