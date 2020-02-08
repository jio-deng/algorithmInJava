package com.dengzm.lib.leetcode.lc_101_150;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @Description 求根到叶子节点数字之和
 * Created by deng on 2020/2/8.
 */
public class Leetcode129 {
    public int sumNumbers(TreeNode root) {
        return sumNumbersCore(root, 0);
    }

    private int sumNumbersCore(TreeNode root, int val) {
        if (root == null) {
            return val;
        }

        int newVal = val * 10 + root.val;

        if (root.left == null && root.right == null) {
            return newVal;
        }

        int result = 0;
        if (root.left != null) {
            result += sumNumbersCore(root.left, newVal);
        }

        if (root.right != null) {
            result += sumNumbersCore(root.right, newVal);
        }

        return result;
    }
}
