package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 17.16. 按摩师
 * @date 2020/3/24 9:25
 */
public class Ms1716 {
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else if (i == 1) {
                dp[i] = Math.max(dp[0], dp[1]);
            } else {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }

        return dp[dp.length - 1];
    }
}
