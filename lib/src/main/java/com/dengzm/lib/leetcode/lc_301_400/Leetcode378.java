package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 有序矩阵中第K小的元素
 * @date 2020/6/27 13:24
 */
public class Leetcode378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length - 1;
        int l = matrix[0][0], r = matrix[n][n];

        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = countUnder(matrix, mid);
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }

    private int countUnder(int[][] matrix, int mid) {
        int x = matrix.length - 1, y = 0, count = 0;
        while (x >= 0 && y <= matrix.length - 1) {
            if (matrix[x][y] <= mid) {
                count += x + 1;
                ++ y;
            } else {
                -- x;
            }
        }
        return count;
    }
}
