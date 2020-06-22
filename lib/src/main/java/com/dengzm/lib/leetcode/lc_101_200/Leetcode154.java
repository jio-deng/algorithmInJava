package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 寻找旋转排序数组中的最小值 II
 * @date 2020/6/22 11:03
 */
public class Leetcode154 {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end --;
            }
        }

        return nums[start];
    }
}
