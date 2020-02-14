package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 不同的子序列
 * @date 2020/2/6 11:44
 */
public class Leetcode115 {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length() || t.length() == 0) {
            return 0;
        }

        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= t.length(); i ++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= t.length(); i ++) {
            for (int j = 1; j <= s.length(); j ++) {
                if (t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }
}
