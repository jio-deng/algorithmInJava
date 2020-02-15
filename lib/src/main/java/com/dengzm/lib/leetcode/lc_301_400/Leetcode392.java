package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 判断子序列
 * @date 2020/2/15 10:28
 */
public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        t = " " + t; // 第一个位置留作跳转状态用

        int[][] dp = new int[t.length()][26];

        for (char c = 'a'; c <= 'z'; c ++) {
            int nextPos = -1;

            for (int i = t.length() - 1; i >= 0; i --) {
                dp[i][c-'a'] = nextPos;
                if (t.charAt(i) == c) {
                    nextPos = i;
                }
            }
        }

        int index = 0;
        for (char c : s.toCharArray()) {
            index = dp[index][c-'a'];
            if (index == -1) {
                return false;
            }
        }

        return true;
    }
}
