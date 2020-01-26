package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 不同路径 II
 * @date 2020/1/25 11:19
 */
public class Leetcode063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1) {
            return 0;
        }

        if (obstacleGrid.length == 1 || obstacleGrid[0].length == 1) {
            for (int[] i : obstacleGrid) {
                for (int ii : i) {
                    if (ii == 1) {
                        return 0;
                    }
                }
            }
            return 1;
        }

        // init data
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        for (int i = m - 2; i >= 0; i --) {
            if (obstacleGrid[i][n - 1] == 1) {
                break;
            }
            dp[i][n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i --) {
            if (obstacleGrid[m - 1][i] == 1) {
                break;
            }
            dp[m - 1][i] = 1;
        }

        // dp
        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[0][0];
    }
}
