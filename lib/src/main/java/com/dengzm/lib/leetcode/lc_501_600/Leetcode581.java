package com.dengzm.lib.leetcode.lc_501_600;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最短无序连续子数组
 * @date 2020/2/23 18:16
 */
public class Leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int[] ordered = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ordered);
        int start = 0, end = nums.length - 1;
        while (start < nums.length) {
            if (ordered[start] != nums[start]) {
                break;
            }

            start ++;
        }

        while (end >= 0) {
            if (ordered[end] != nums[end]) {
                break;
            }

            end --;
        }

        return end >= start ? end - start + 1 : 0;
    }
}
