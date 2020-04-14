package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题10- I. 斐波那契数列 + 面试题10- II. 青蛙跳台阶问题
 * @date 2020/4/14 12:40
 */
public class Ms010 {
    private int MOD = 1000000007;

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i ++) {
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }

        return dp[n];
    }

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }

        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i ++) {
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }

        return dp[n];
    }
}
