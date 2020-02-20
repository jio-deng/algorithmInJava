package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 岛屿的周长
 * @date 2020/2/20 19:50
 */
public class Leetcode463 {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i-1][j] == 0) {
                        ans ++;
                    }

                    if (j == 0 || grid[i][j-1] == 0) {
                        ans ++;
                    }

                    if (j == grid[0].length - 1 || grid[i][j+1] == 0) {
                        ans ++;
                    }

                    if (i == grid.length - 1 || grid[i+1][j] == 0) {
                        ans ++;
                    }
                }

            }
        }

        return ans;
    }
}
