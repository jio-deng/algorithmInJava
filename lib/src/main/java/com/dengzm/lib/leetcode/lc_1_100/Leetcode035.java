package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 搜索插入位置
 * @date 2020/1/17 10:54
 */
public class Leetcode035 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return searchBinary(nums, target, 0, nums.length - 1);
    }

    private int searchBinary(int[] nums, int target, int start, int end) {
        if (start > end) {
            return start;
        }

        int pivot = (start + end) / 2;
        if (target == nums[pivot]) {
            return pivot;
        } else if (target > nums[pivot]) {
            return searchBinary(nums, target, pivot + 1, end);
        } else {
            return searchBinary(nums, target, start, pivot - 1);
        }
    }
}
