package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 搜索二维矩阵 II
 * @date 2020/6/15 10:13
 */
public class Leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length, m = matrix[0].length;

        int row = n - 1, col = 0;
        while (row >= 0 && col < m) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row --;
            } else {
                col ++;
            }
        }

        return false;
    }
}
