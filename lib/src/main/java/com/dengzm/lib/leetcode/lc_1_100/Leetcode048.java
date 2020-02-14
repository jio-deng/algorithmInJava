package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 旋转图像
 * @date 2020/1/22 11:38
 */
public class Leetcode048 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }

        int start = 0;
        int end = matrix.length - 1;

        for (int i = start; i <= end / 2; i ++) {
            for (int j = start; j <= (end - 1) / 2; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[end - j][i];
                matrix[end - j][i] = matrix[end - i][end - j];
                matrix[end - i][end - j] = matrix[j][end - i];
                matrix[j][end - i] = temp;
            }
        }
    }
}
