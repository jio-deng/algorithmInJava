package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 车的可用捕获量
 * @date 2020/3/20 12:25
 */
public class Leetcode999 {
    public int numRookCaptures(char[][] board) {
        int row = -1, col = -1;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        if (row == -1) {
            return 0;
        }

        int ans = 0;

        for (int i = row - 1; i >= 0; i --) {
            if (board[i][col] == 'B') {
                break;
            } else if (board[i][col] == 'p') {
                ans ++;
                break;
            }
        }

        for (int i = row + 1; i < board.length; i ++) {
            if (board[i][col] == 'B') {
                break;
            } else if (board[i][col] == 'p') {
                ans ++;
                break;
            }
        }

        for (int j = col - 1; j >= 0; j --) {
            if (board[row][j] == 'B') {
                break;
            } else if (board[row][j] == 'p') {
                ans ++;
                break;
            }
        }

        for (int j = col + 1; j < board[0].length; j ++) {
            if (board[row][j] == 'B') {
                break;
            } else if (board[row][j] == 'p') {
                ans ++;
                break;
            }
        }


        return ans;
    }
}
