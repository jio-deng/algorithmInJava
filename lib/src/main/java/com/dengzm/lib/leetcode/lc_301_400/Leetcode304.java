package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二维区域和检索 - 矩阵不可变
 * @date 2020/4/8 10:45
 */
public class Leetcode304 {
    class NumMatrix {
        int[][] sum = null;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) {
                return;
            }

            int n = matrix.length, m = matrix[0].length;
            sum = new int[n+1][m+1];

            for (int i = 1; i <= n; i ++) {
                for (int j = 1; j <= m; j ++) {
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sum == null) {
                return 0;
            }

            return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
