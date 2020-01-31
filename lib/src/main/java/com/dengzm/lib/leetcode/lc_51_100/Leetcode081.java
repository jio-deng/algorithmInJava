package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 搜索旋转排序数组 II
 * @date 2020/1/29 12:23
 */
public class Leetcode081 {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] == nums[mid]) {
                start ++;
                continue;
            }

            if (nums[start] < nums[mid]) {
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return false;
    }

}
