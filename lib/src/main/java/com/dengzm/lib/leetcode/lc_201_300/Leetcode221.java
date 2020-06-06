package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最大正方形
 * @date 2020/5/8 11:57
 */
public class Leetcode221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + (matrix[i-1][j-1] == '1' ? 1 : 0);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (matrix[i][j] != '1') {
                    continue;
                }

                int length = Math.min(n-i, m-j);
                while (length > 0) {
                    int val = dp[i+length][j+length] + dp[i][j] - dp[i+length][j] - dp[i][j+length];
                    if (val == length * length) {
                        max = Math.max(max, val);
                        break;
                    }

                    length --;
                }
            }
        }

        return max;
    }
}
