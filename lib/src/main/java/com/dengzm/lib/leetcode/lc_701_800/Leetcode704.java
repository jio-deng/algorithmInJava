package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二分查找
 * @date 2020/3/2 10:27
 */
public class Leetcode704 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }

        return -1;
    }
}
