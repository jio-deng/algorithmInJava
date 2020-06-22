package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 保持城市天际线
 * @date 2020/6/19 11:50
 */
public class Leetcode807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                ans += Math.min(row[i], col[j]);
                ans -= grid[i][j];
            }
        }

        return ans;
    }
}
