package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 生命游戏
 * @date 2020/4/2 11:57
 */
public class Leetcode289 {
    public void gameOfLife(int[][] board) {
        int[] dx = new int[] {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dy = new int[] {0, 0, 1, -1, 1, -1, -1, 1};
        int n = board.length, m = board[0].length;
        int[][] ans = new int[n][m];

        int x, y;
        for (int r = 0; r < n; r ++) {
            for (int c = 0; c < m; c ++) {
                int num = 0;
                for (int i = 0; i < 8; i ++) {
                    x = c + dx[i];
                    y = r + dy[i];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }

                    if (board[y][x] == 1) {
                        num ++;
                    }
                }

                if (board[r][c] == 1) {
                    if (num == 2 || num == 3) {
                        ans[r][c] = 1;
                    }
                } else {
                    if (num == 3) {
                        ans[r][c] = 1;
                    }
                }
            }
        }

        for (int r = 0; r < n; r ++) {
            for (int c = 0; c < m; c++) {
                board[r][c] = ans[r][c];
            }
        }
    }
}
