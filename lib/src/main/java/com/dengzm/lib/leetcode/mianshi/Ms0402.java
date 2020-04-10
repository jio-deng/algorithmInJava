package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 04.02. 最小高度树
 * @date 2020/4/9 18:25
 */
public class Ms0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTCore(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTCore(nums, start, mid - 1);
        node.right = sortedArrayToBSTCore(nums, mid + 1, end);
        return node;
    }
}
