package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 甲板上的战舰
 * @date 2020/4/14 11:40
 */
public class Leetcode419 {
    private int[] dx = {-1, 0};
    private int[] dy = {0, -1};

    public int countBattleships(char[][] board) {
        int time = 0, n = board.length, m = board[0].length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (board[i][j] == '.') {
                    continue;
                }

                boolean isShip = true;
                for (int k = 0; k < 2; k ++) {
                    int y = i + dy[k], x = j + dx[k];
                    if (y < 0 || x < 0) {
                        continue;
                    }

                    if (board[y][x] == 'X') {
                        isShip = false;
                        break;
                    }
                }

                if (isShip) {
                    time ++;
                }
            }
        }

        return time;
    }
}
