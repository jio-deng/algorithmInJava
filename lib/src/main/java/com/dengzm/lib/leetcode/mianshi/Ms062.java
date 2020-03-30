package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题62. 圆圈中最后剩下的数字
 * @date 2020/3/30 9:18
 */
public class Ms062 {
    public int lastRemaining(int n, int m) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            dp[i] = (dp[i-1] + m) % n;
        }

        return dp[n];
    }
}
