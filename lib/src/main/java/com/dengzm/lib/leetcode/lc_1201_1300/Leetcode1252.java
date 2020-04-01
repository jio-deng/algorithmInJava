package com.dengzm.lib.leetcode.lc_1201_1300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 奇数值单元格的数目
 * @date 2020/3/31 17:03
 */
public class Leetcode1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] cols = new int[m];
        for (int[] ind : indices) {
            rows[ind[0]] ++;
            cols[ind[1]] ++;
        }

        int ans = 0;
        int col = 0;
        for (int c : cols) {
            if (c % 2 == 1) {
                col ++;
            }
        }

        for (int r : rows) {
            if (r % 2 == 1) {
                ans += m - col;
            } else {
                ans += col;
            }
        }

        return ans;
    }
}
