package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 寻找峰值
 * @date 2020/3/28 11:56
 */
public class Leetcode162 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 0;
        }

        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] < nums[i-1]) {
                return i-1;
            }
        }

        return nums.length - 1;
    }
}
