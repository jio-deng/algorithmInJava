package com.dengzm.lib.leetcode.mianshi;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 01.08. 零矩阵
 * @date 2020/4/7 19:53
 */
public class Ms0108 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[] hasZero = new boolean[n+m];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (matrix[i][j] == 0) {
                    hasZero[i] = true;
                    hasZero[n+j] = true;
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            if (hasZero[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int j = 0; j < m; j ++) {
            if (hasZero[n+j]) {
                for (int i = 0; i < n; i ++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
