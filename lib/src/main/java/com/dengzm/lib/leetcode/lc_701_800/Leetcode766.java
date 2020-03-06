package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 托普利茨矩阵
 * @date 2020/3/6 10:13
 */
public class Leetcode766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < m; i ++) {
            int r = 0, c = i, value = matrix[r][c];
            while (++r < n && ++c < m) {
                if (matrix[r][c] != value) {
                    return false;
                }
            }
        }

        for (int i = 1; i < n; i ++) {
            int r = i, c = 0, value = matrix[r][c];
            while (++r < n && ++c < m) {
                if (matrix[r][c] != value) {
                    return false;
                }
            }
        }

        return true;
    }
}
