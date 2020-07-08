package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最长重复子数组
 * @date 2020/7/1 21:14
 */
public class Leetcode718 {
    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length+1][B.length+1];
        int result = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
