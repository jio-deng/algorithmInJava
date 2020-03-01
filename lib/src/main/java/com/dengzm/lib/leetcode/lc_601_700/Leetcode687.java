package com.dengzm.lib.leetcode.lc_601_700;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最长同值路径
 * @date 2020/3/1 9:40
 */
public class Leetcode687 {
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        longestUnivaluePathCore(root);
        return max - 1 >= 0 ? max - 1 : 0;
    }

    private int longestUnivaluePathCore(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = longestUnivaluePathCore(root.left);
        int right = longestUnivaluePathCore(root.right);

        int sum = 1;
        if (root.left != null && root.left.val == root.val) {
            sum += left;
        } else {
            left = 0;
        }

        if (root.right != null && root.right.val == root.val) {
            sum += right;
        } else {
            right = 0;
        }

        System.out.println(max + " " + sum);
        max = Math.max(sum, max);

        return 1 + Math.max(left, right);
    }
}
