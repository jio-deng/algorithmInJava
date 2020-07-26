package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 地下城游戏
 * @date 2020/7/12 10:42
 */
class Leetcode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length, col = dungeon[0].length;
        int[][] dp = new int[row][col];

        for (int i = row-1; i >= 0; i --) {
            for (int j = col-1; j >= 0; j --) {
                if (i == row-1 && j == col-1) { //终点的情况
                    dp[i][j] = Math.max(1, 1-dungeon[i][j]);
                } else if (i == row-1) { //最后一行的情况
                    dp[i][j] = Math.max(1, dp[i][j+1]-dungeon[i][j]);
                } else if (j == col-1) { //最后一列的情况
                    dp[i][j] = Math.max(1, dp[i+1][j]-dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
                }
            }
        }

        return dp[0][0];
    }
}
