package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题04. 二维数组中的查找
 * @date 2020/4/14 12:10
 */
public class Ms004 {
    int n, m;
    boolean[][] isVisited;

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        n = matrix.length;
        m = matrix[0].length;
        isVisited = new boolean[n][m];

        return findTarget(matrix, 0, 0, target);
    }

    private boolean findTarget(int[][] matrix, int y, int x, int target) {
        if (y >= n || x >= m || isVisited[y][x]) {
            return false;
        }

        isVisited[y][x] = true;

        return matrix[y][x] == target || findTarget(matrix, y + 1, x, target) || findTarget(matrix, y, x + 1, target);
    }
}
