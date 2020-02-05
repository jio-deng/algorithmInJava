package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 交错字符串
 * @date 2020/2/5 10:11
 */
public class Leetcode097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int[] letters = new int[128];
        for (int i = 0; i < s1.length(); i ++) {
            letters[s1.charAt(i)] ++;
        }

        for (int i = 0; i < s2.length(); i ++) {
            letters[s2.charAt(i)] ++;
        }

        for (int i = 0; i < s3.length(); i ++) {
            letters[s3.charAt(i)] --;
        }

        for (int letter : letters) {
            if (letter != 0) {
                return false;
            }
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= s1.length(); i ++) {
            if (s1.charAt(i-1) != s3.charAt(i-1)) {
                break;
            }

            dp[i][0] = 1;
        }

        for (int i = 1; i <= s2.length(); i ++) {
            if (s2.charAt(i-1) != s3.charAt(i-1)) {
                break;
            }

            dp[0][i] = 1;
        }

        for (int i = 1; i <= s1.length(); i ++) {
            for (int j = 1; j <= s2.length(); j ++) {
                if (dp[i-1][j] == 1 && s1.charAt(i-1) == s3.charAt(i+j-1) || dp[i][j-1] == 1 && s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    dp[i][j]= 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[s1.length()][s2.length()] == 1;
    }
}
