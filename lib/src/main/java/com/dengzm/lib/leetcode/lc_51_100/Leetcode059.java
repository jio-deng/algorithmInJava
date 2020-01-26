package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 螺旋矩阵 II
 * @date 2020/1/25 10:41
 */
public class Leetcode059 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }

        int[][] result = new int[n][n];
        int count = 1;
        int rStart = 0, rEnd = n - 1, cStart = 0, cEnd = n - 1;
        while (rStart < rEnd && cStart < cEnd) {
            for (int c = cStart; c <= cEnd; c ++) {
                result[rStart][c] = count;
                count ++;
            }

            for (int r = rStart + 1; r <= rEnd; r ++) {
                result[r][cEnd] = count;
                count ++;
            }

            for (int c = cEnd - 1; c >= cStart; c --) {
                result[rEnd][c] = count;
                count ++;
            }

            if (rEnd - rStart > 1) {
                for (int r = rEnd - 1; r >= rStart + 1; r --) {
                    result[r][cStart] = count;
                    count ++;
                }
            }

            rStart ++;
            rEnd --;
            cStart ++;
            cEnd --;
        }

        if (rStart == rEnd && cStart == cEnd) {
            result[rStart][cStart] = count;
        }

        return result;
    }
}
