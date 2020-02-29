package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 子数组最大平均数 I
 * @date 2020/2/28 10:20
 */
public class Leetcode643 {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k) {
            return 0;
        }

        int start;
        int end = k - 1;
        double sum = -100000;
        double ave = -100000;

        for (start = 0; start < nums.length - k + 1; start ++, end ++) {
            if (sum == -100000) {
                sum = 0;
                for (int i = start; i <= end; i ++) {
                    sum += nums[i];
                }
            } else {
                sum -= nums[start-1];
                sum += nums[end];
            }

            ave = Math.max(ave, sum / k);
        }

        return ave;
    }
}
