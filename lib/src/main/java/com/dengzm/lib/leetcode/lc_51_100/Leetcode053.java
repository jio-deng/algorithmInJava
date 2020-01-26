package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最大子序和
 * @date 2020/1/20 13:58
 */
public class Leetcode053 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }

            max = Math.max(max, nums[i]);
        }

        return max;
    }

}
