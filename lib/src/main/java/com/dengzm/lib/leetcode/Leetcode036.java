package com.dengzm.lib.leetcode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 有效的数独
 * @date 2020/1/17 11:59
 */
public class Leetcode036 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boxes = new int[9][9];

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
