package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 被围绕的区域
 * @date 2020/2/27 10:24
 */
public class Leetcode130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i ++) {
            mark(board, i, 0);
            mark(board, i, board[0].length - 1);
        }

        for (int j = 0; j < board[0].length; j ++) {
            mark(board, 0, j);
            mark(board, board.length - 1, j);
        }

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void mark(char[][] board, int row, int col) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
            return;
        }

        if (board[row][col] == 'O') {
            board[row][col] = '-';
            mark(board, row, col - 1);
            mark(board, row, col + 1);
            mark(board, row - 1, col);
            mark(board, row + 1, col);
        }
    }
}
