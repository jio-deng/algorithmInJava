package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最小路径和
 * @date 2020/1/25 11:26
 */
public class Leetcode064 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) {
            return grid[0][0];
        } else if (m == 1) {
            int result = 0;
            for (int i = 0; i < n; i ++) {
                result += grid[0][i];
            }

            return result;
        } else if (n == 1) {
            int result = 0;
            for (int i = 0; i < m; i ++) {
                result += grid[i][0];
            }

            return result;
        }

        // init data
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];

        for (int i = m - 2; i >= 0; i --) {
            dp[i][n - 1] = grid[i][n - 1] + dp[i + 1][n - 1];
        }
        for (int i = n - 2; i >= 0; i --) {
            dp[m - 1][i] = grid[m - 1][i] + dp[m - 1][i + 1];
        }

        // dp
        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }

        return dp[0][0];
    }
}
