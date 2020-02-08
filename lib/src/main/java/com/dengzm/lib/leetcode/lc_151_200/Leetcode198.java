package com.dengzm.lib.leetcode.lc_151_200;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 打家劫舍I
 * @date 2020/1/10 13:22
 */
public class Leetcode198 {
    public int[] memo;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dp(nums, 0);
    }

    public int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        if (memo[start] != -1) {
            return memo[start];
        }
        int res = Math.max(dp(nums, start + 1), dp(nums, start + 2) + nums[start]);
        memo[start] = res;

        return res;
    }
}
