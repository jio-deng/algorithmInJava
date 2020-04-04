package com.dengzm.lib.leetcode.lc_201_300;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 完全平方数
 * @date 2020/4/4 9:42
 */
public class Leetcode279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int m = 1;
            while (m * m <= i) {
                dp[i] = Math.min(dp[i], dp[i - m * m] + 1);
                m ++;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode279 leetcode279 = new Leetcode279();
        leetcode279.numSquares(12);
    }
}
