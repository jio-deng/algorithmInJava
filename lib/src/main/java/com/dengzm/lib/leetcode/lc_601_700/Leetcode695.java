package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 岛屿的最大面积
 * @date 2020/3/15 9:17
 */
public class Leetcode695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                max = Math.max(getArea(grid, isVisited, i, j), max);
            }
        }

        return max;
    }

    private int getArea(int[][] grid, boolean[][] isVisited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || isVisited[i][j]) {
            return 0;
        }

        isVisited[i][j] = true;

        return getArea(grid, isVisited, i + 1, j) + getArea(grid, isVisited, i - 1, j) +
                getArea(grid, isVisited, i, j + 1) + getArea(grid, isVisited, i, j - 1) + 1;
    }
}
