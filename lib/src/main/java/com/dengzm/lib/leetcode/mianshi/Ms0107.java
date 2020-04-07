package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 01.07. 旋转矩阵
 * @date 2020/4/7 19:16
 */
public class Ms0107 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; i ++) {
            for (int j = i+1; j < n; j ++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n / 2; j ++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }

    }
}
