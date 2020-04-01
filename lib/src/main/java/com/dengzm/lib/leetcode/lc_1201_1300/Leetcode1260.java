package com.dengzm.lib.leetcode.lc_1201_1300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二维网格迁移
 * @date 2020/3/31 17:10
 */
public class Leetcode1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        k %= m*n;
        while (k > 0) {
            int[][] tmp = new int[n][m];
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < m; j ++) {
                    int x = j == m - 1 ? 0 : j + 1;
                    int y = j == m - 1 ? i == n - 1 ? 0 : i + 1 : i;
                    tmp[y][x] = grid[i][j];
                }
            }

            grid = tmp;
            k --;
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int[] g : grid) {
            List<Integer> list = new ArrayList<>();
            for (int a : g) {
                list.add(a);
            }

            res.add(list);
        }

        return res;
    }
}
