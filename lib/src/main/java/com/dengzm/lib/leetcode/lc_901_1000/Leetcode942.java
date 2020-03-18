package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 增减字符串匹配
 * @date 2020/3/18 10:08
 */
public class Leetcode942 {
    public int[] diStringMatch(String S) {
        if (S == null || S.length() == 0) {
            return new int[] {0};
        }

        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; i ++) {
            if (S.charAt(i) == 'I') {
                ans[i] = lo ++;
            } else {
                ans[i] = hi --;
            }
        }

        ans[N] = lo;
        return ans;
    }
}
