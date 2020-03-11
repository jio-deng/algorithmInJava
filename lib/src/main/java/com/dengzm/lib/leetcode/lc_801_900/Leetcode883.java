package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 三维形体投影面积
 * @date 2020/3/11 12:09
 */
public class Leetcode883 {
    public int projectionArea(int[][] grid) {
        int ans = 0;
        int n = grid.length, m = grid[0].length;
        ans += m*n;

        for (int i = 0; i < n; i ++) {
            int max = 0;
            for (int j = 0; j < m; j ++) {
                max = Math.max(max, grid[i][j]);
                if (grid[i][j] == 0) {
                    ans --;
                }
            }

            ans += max;
        }

        for (int j = 0; j < m; j ++) {
            int max = 0;
            for (int i = 0; i < n; i ++) {
                max = Math.max(max, grid[i][j]);
            }

            ans += max;
        }

        return ans;
    }
}
