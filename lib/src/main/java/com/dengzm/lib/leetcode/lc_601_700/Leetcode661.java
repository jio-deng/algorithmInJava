package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 图片平滑器
 * @date 2020/2/29 10:13
 */
public class Leetcode661 {
    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i ++) {
            for (int j = 0; j < M[0].length; j ++) {
                int count = 1;
                int sum = M[i][j];
                if (j > 0) {
                    sum += M[i][j-1];
                    count ++;

                    if (i > 0) {
                        sum += M[i-1][j-1];
                        count ++;
                    }

                    if (i < M.length - 1) {
                        sum += M[i+1][j-1];
                        count ++;
                    }
                }

                if (j < M[0].length - 1) {
                    sum += M[i][j+1];
                    count ++;

                    if (i > 0) {
                        sum += M[i-1][j+1];
                        count ++;
                    }

                    if (i < M.length - 1) {
                        sum += M[i+1][j+1];
                        count ++;
                    }
                }

                if (i > 0) {
                    sum += M[i-1][j];
                    count ++;
                }

                if (i < M.length - 1) {
                    sum += M[i+1][j];
                    count ++;
                }

                res[i][j] = sum / count;
            }
        }

        return res;
    }
}
