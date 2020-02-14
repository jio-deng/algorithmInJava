package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 丑数 II
 * @date 2020/2/14 11:26
 */
public class Leetcode264 {
    public int nthUglyNumber(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;

        for (int i = 1; i < n; i ++) {
            dp[i] = Math.min(2 * dp[index_2], Math.min(3 * dp[index_3], 5 * dp[index_5]));

            if (dp[i] == 2 * dp[index_2]) {
                index_2 ++;
            }

            if (dp[i] == 3 * dp[index_3]) {
                index_3 ++;
            }

            if (dp[i] == 5 * dp[index_5]) {
                index_5 ++;
            }
        }

        return dp[n-1];
    }
}
