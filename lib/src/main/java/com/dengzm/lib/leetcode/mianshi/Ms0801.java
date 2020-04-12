package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 08.01. 三步问题
 * @date 2020/4/11 17:27
 */
public class Ms0801 {
    private int MOD = 1000000007;
    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }

        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i ++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            dp[i] %= MOD;
        }

        return (int) dp[n];
    }
}
