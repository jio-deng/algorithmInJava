package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 解数独
 * @date 2020/1/17 12:24
 */
public class Leetcode037 {
    public void solveSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boxes = new int[9][9];

        if (!isValidSudoku(board, rows, columns, boxes)) {
            return;
        }

        backTrace(0, 0, 0, board, rows, columns, boxes);
    }

    private boolean backTrace(int i, int j, int count, char[][] board, int[][] rows, int[][] columns, int[][] boxes) {
        if (count >= 81) {
            return true;
        }

        while (i < 9 && j < 9 && board[i][j] != '.') {
            count ++;
            j ++;
            if (j == 9) {
                i ++;
                j = 0;
            }
        }

        if (count >= 81) {
            return true;
        }

        int boxIndex = i / 3 * 3 + j / 3;
        for (int n = 0; n < 9; n ++) {
            if (rows[i][n] == 1 || columns[j][n] == 1 || boxes[boxIndex][n] == 1) {
                continue;
            }

            count ++;
            board[i][j] = (char) (n + '1');
            rows[i][n] = 1;
            columns[j][n] = 1;
            boxes[boxIndex][n] = 1;

            int ni = i;
            int nj = j;
            nj ++;
            if (9 == nj) {
                ni ++;
                nj = 0;
            }

            if (backTrace(ni, nj, count, board, rows, columns, boxes)) {
                return true;
            }

            count --;
            board[i][j] = '.';
            rows[i][n] = 0;
            columns[j][n] = 0;
            boxes[boxIndex][n] = 0;
        }

        return false;
    }

    private boolean isValidSudoku(char[][] board, int[][] rows, int[][] columns, int[][] boxes) {
        if (board == null || board.length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i ++) {
            char[] row = board[i];

            for (int j = 0; j < row.length; j ++) {
                char c = row[j];
                if (c == '.') {
                    continue;
                }

                int index = c - '1';
                rows[i][index] ++;
                columns[j][index] ++;

                int boxIndex = i / 3 * 3 + j / 3;
                boxes[boxIndex][index] ++;

                if (rows[i][index] > 1 || columns[j][index] > 1 || boxes[boxIndex][index] > 1) {
                    return false;
                }
            }
        }

        return true;
    }


}
