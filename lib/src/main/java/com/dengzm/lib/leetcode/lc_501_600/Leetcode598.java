package com.dengzm.lib.leetcode.lc_501_600;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 范围求和 II
 * @date 2020/2/24 16:10
 */
public class Leetcode598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }
        int row  = ops[0][0];
        int col = ops[0][1];

        for (int i = 1; i < ops.length; i ++) {
            row = Math.min(row, ops[i][0]);
            col = Math.min(col, ops[i][1]);
        }

        return row * col;
    }
}
