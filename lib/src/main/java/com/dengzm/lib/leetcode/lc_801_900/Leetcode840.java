package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 矩阵中的幻方
 * @date 2020/3/10 10:31
 */
public class Leetcode840 {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 5) {
                    count += grid[i - 1][j - 1] * grid[i - 1][j] * grid[i - 1][j + 1] * grid[i][j - 1] * grid[i][j]
                            * grid[i][j + 1] * grid[i + 1][j - 1] * grid[i + 1][j] * grid[i + 1][j + 1] == 362880
                            && grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] == 15
                            && grid[i][j - 1] + grid[i][j] + grid[i][j + 1] == 15
                            && grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1] == 15
                            && grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1] == 15
                            && grid[i - 1][j] + grid[i][j] + grid[i + 1][j] == 15
                            && grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1] == 15
                            && grid[i - 1][j - 1] + grid[i][j] + grid[i + 1][j + 1] == 15
                            && grid[i - 1][j + 1] + grid[i][j] + grid[i + 1][j - 1] == 15 ? 1 : 0;
                }
            }
        }
        return count;
    }
}
