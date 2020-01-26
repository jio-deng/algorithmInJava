package com.dengzm.lib.leetcode.lc_1_50;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 实现 strStr()
 * @date 2020/1/3 21:40
 */
public class Leetcode028 {

    class KMP {
        private int[][] dp;
        private String pat;

        public KMP(String pat) {
            this.pat = pat;
            dp = new int[pat.length()][256];
            // base case
            dp[0][pat.charAt(0)] = 1;
            // 影子状态
            int x = 0;
            // 状态图
            for (int j = 1; j < pat.length(); j ++) {
                for (int c = 0; c < 256; c ++) {
                    if (pat.charAt(j) == c) {
                        dp[j][c] = j + 1;
                    } else {
                        dp[j][c] = dp[x][c];
                    }
                }

                x = dp[x][pat.charAt(j)];
            }
        }

        public int search(String txt) {
            int M = pat.length();
            int N = txt.length();
            // pat 的初始态为 0
            int j = 0;
            for (int i = 0; i < N; i++) {
                // 计算 pat 的下一个状态
                j = dp[j][txt.charAt(i)];
                // 到达终止态，返回结果
                if (j == M) return i - M + 1;
            }
            // 没到达终止态，匹配失败
            return -1;
        }
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        if (haystack.length() == 0 || needle.length() == 0) {
            return 0;
        }

        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }

    /*执行结果：通过
      显示详情
      执行用时 :21 ms, 在所有 Java 提交中击败了11.86%的用户
      内存消耗 :73 MB, 在所有 Java 提交中击败了5.02%的用户*/


    /**
     * 暴力法
     */
    public int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        if (haystack.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i ++) {

            int j = 0;
            for (; j < needle.length(); j ++) {
                if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
