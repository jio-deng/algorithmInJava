package com.dengzm.lib.leetcode.lc_501_600;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 01 矩阵
 * @date 2020/4/15 11:59
 */
public class Leetcode542 {
    private int MOD = 10000;
    private int MAX = 2 * MOD + 1;

    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] ans = new int[n][m];

        for (int[] a : ans) {
            Arrays.fill(a, 201);
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = Math.min(i > 0 ? ans[i-1][j] : MAX, j > 0 ? ans[i][j-1] : MAX) + 1;
                }

                queue.offer(i * MOD + j);
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    int y = v / MOD, x = v % MOD;


                    if (y > 0 && ans[y-1][x] > ans[y][x] + 1) {
                        ans[y-1][x] = ans[y][x] + 1;
                        queue.offer((y-1) * MOD + x);
                    }

                    if (x > 0 && ans[y][x-1] > ans[y][x] + 1) {
                        ans[y][x-1] = ans[y][x] + 1;
                        queue.offer(y * MOD + x - 1);
                    }
                }
            }
        }

        return ans;
    }
}
