package com.dengzm.lib.leetcode.lc_1201_1300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 分割回文串 III
 * @date 2020/1/26 21:26
 */
public class Leetcode1278 {
    public int palindromePartition(String s, int k) {
        if (s == null || s.length() < k) {
            return -1;
        }

        int[][] pali = new int[s.length() + 1][s.length() + 1];
        for (int i = s.length(); i >= 1; i --) {
            for (int j = i; j <= s.length(); j ++) {
                if (j - i >= 2) {
                    pali[i][j] = pali[i+1][j-1];
                }

                if (s.charAt(i-1) != s.charAt(j-1)) {
                    pali[i][j] ++;
                }
            }
        }

        int[][] dp = new int[k+1][s.length()+1];
        for (int i = 1; i < k+1; i ++) {
            for (int j = i; j <= s.length(); j ++) {
                if (i == 1) {
                    dp[i][j] = pali[i][j];
                } else {
                    dp[i][j] = dp[i-1][i-1] + pali[i][j];
                    for (int x = i; x < j; x ++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][x] + pali[x+1][j]);
                    }
                }
            }
        }

        return dp[k][s.length()];
    }
}
