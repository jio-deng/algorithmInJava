package com.dengzm.lib.leetcode.lc_601_700;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最大二叉树
 * @date 2020/6/13 12:46
 */
public class Leetcode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeCore(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTreeCore(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(nums[start]);
        }

        int index = -1;
        int val = Integer.MIN_VALUE;

        for (int i = start; i <= end; i ++) {
            if (val < nums[i]) {
                val = nums[i];
                index = i;
            }
        }

        TreeNode ans = new TreeNode(val);
        ans.left = constructMaximumBinaryTreeCore(nums, start, index-1);
        ans.right = constructMaximumBinaryTreeCore(nums, index+1, end);
        return ans;
    }
}
