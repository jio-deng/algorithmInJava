package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 爬楼梯
 * @date 2020/1/27 16:13
 */
public class Leetcode070 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i ++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }
}
