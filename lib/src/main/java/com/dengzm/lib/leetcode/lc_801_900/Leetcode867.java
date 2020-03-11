package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 转置矩阵
 * @date 2020/3/11 11:16
 */
public class Leetcode867 {
    public int[][] transpose(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                res[j][i] = A[i][j];
            }
        }

        return res;
    }
}
