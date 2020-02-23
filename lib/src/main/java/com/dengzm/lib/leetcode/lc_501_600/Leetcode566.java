package com.dengzm.lib.leetcode.lc_501_600;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 重塑矩阵
 * @date 2020/2/22 21:39
 */
public class Leetcode566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int nr = nums.length;
        int nc = nums[0].length;

        if (nr * nc != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        int count = 0;
        for (int i = 0; i < r; i ++) {
            for (int j = 0; j < c; j ++) {
                int row = count / nc;
                int col = count % nc;
                ans[i][j] = nums[row][col];

                count ++;
            }
        }

        return ans;
    }
}
