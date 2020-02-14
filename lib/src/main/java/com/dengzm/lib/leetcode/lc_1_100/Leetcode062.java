package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 不同路径
 * @date 2020/1/25 11:08
 */
public class Leetcode062 {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        // init data
        int[][] dp = new int[m][n];
        for (int i = m - 2; i >= 0; i --) {
            dp[i][n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i --) {
            dp[m - 1][i] = 1;
        }

        // dp
        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }
}
