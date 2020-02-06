package com.dengzm.lib.leetcode.lc_101_150;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.HashMap;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 平衡二叉树
 * @date 2020/2/6 10:00
 */
public class Leetcode110 {
    private HashMap<TreeNode, Integer> map;
    private boolean isBanlanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        map = new HashMap<>();
        isBanlanced = true;
        balancedDepthCore(root);

        return isBanlanced;
    }

    private int balancedDepthCore(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = root.left == null ? 0 : map.containsKey(root.left) ? map.get(root.left) : balancedDepthCore(root.left);
        int rightDepth = root.right == null ? 0 : map.containsKey(root.right) ? map.get(root.right) : balancedDepthCore(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBanlanced = false;
        }

        if (root.left != null) {
            map.put(root.left, leftDepth);
        }

        if (root.right != null) {
            map.put(root.right, rightDepth);
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
