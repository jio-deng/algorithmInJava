package com.dengzm.lib.leetcode.lc_51_100;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 矩阵置零
 * @date 2020/1/29 9:59
 */
public class Leetcode073 {
    public void setZeroes(int[][] matrix) {
        boolean rowFlag = false;
        boolean colFlag = false;

        // first row
        for (int i = 0; i < matrix[0].length; i ++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        // first col
        for (int i = 0; i < matrix.length; i ++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        // other row and col
        for (int i = 1; i < matrix.length; i ++) {
            for (int j = 1; j < matrix[1].length; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // set zeros
        for (int i = 1; i < matrix.length; i ++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int i = 1; i < matrix[0].length; i ++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (rowFlag) {
            Arrays.fill(matrix[0], 0);
        }
        if (colFlag) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
    }
}
