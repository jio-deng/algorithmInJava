package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 除自身以外数组的乘积
 * @date 2020/6/4 9:47
 */
public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[][] dp = new int[2][nums.length+1];
        dp[0][0] = 1;
        dp[1][nums.length] = 1;
        for (int i = 0; i < nums.length; i ++) {
            dp[0][i+1] = dp[0][i] * nums[i];
            dp[1][nums.length - i - 1] = dp[1][nums.length - i] * nums[nums.length - i - 1];
        }

        for (int i = 0; i < nums.length; i ++) {
            ans[i] = dp[0][i] * dp[1][i+1];
        }

        return ans;
    }
}
