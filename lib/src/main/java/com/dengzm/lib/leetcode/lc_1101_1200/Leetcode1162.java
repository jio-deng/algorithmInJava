package com.dengzm.lib.leetcode.lc_1101_1200;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 地图分析
 * @date 2020/3/29 9:58
 */
public class Leetcode1162 {
    private static int INF = 1000000;
    public int maxDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int[] d : dp) {
            Arrays.fill(d, INF);
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    int i1 = i > 0 ? dp[i-1][j] : INF;
                    int i2 = j > 0 ? dp[i][j-1] : INF;
                    dp[i][j] = Math.min(i1, i2) + 1;
                }
            }
        }

        int res = -1;
        for (int i = n - 1; i >= 0; i --) {
            for (int j = m - 1; j >= 0; j --) {
                if (grid[i][j] == 0) {
                    int i1 = i < n-1 ? dp[i+1][j] : INF;
                    int i2 = j < n-1 ? dp[i][j+1] : INF;
                    dp[i][j] = Math.min(Math.min(i1, i2) + 1, dp[i][j]);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res >= INF ? -1 : res;
    }
}
