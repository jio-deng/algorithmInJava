package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 单词搜索
 * @date 2020/1/29 11:00
 */
public class Leetcode079 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        if (board.length * board[0].length < word.length()) {
            return false;
        }

        boolean[] used = new boolean[board.length * board[0].length];
        return existCore(board, word, 0, -1, used);
    }

    private boolean existCore(char[][] board, String word, int index, int curState, boolean[] used) {
        if (index >= word.length()) {
            return true;
        }

        if (curState == -1) {
            for (int i = 0; i < board.length; i ++) {
                for (int j = 0; j < board[0].length; j ++) {
                    if (board[i][j] == word.charAt(index) && iiiCore(board, word, index, used, i, j)) {
                        return true;
                    }
                }
            }
        } else {
            int i = curState / board[0].length;
            int j = curState % board[0].length;

            if (i - 1 >= 0 && board[i-1][j] == word.charAt(index) && iiiCore(board, word, index, used, i-1, j)) {
                return true;
            }

            if (i + 1 < board.length && board[i+1][j] == word.charAt(index) && iiiCore(board, word, index, used, i+1, j)) {
                return true;
            }

            if (j - 1 >= 0 && board[i][j-1] == word.charAt(index) && iiiCore(board, word, index, used, i, j-1)) {
                return true;
            }

            if (j + 1 < board[0].length && board[i][j+1] == word.charAt(index) && iiiCore(board, word, index, used, i, j+1)) {
                return true;
            }
        }

        return false;
    }

    private boolean iiiCore(char[][] board, String word, int index, boolean[] used, int i, int j) {
        int pos = i * board[0].length + j;

        if (used[pos]) {
            return false;
        }

        used[pos] = true;

        boolean result = existCore(board, word, index + 1, pos, used);
        if (result) {
            return true;
        }

        used[pos] = false;

        return false;
    }

//    public boolean exist(char[][] board, String word) {
//        if (board == null || board.length == 0 || board[0].length == 0) {
//            return false;
//        }
//
//        if (board.length * board[0].length < word.length()) {
//            return false;
//        }
//
//        boolean[] used = new boolean[board.length * board[0].length];
//        for (int i = 0; i < board.length; i ++) {
//            for (int j = 0; j < board[0].length; j ++) {
//                if (board[i][j] == word.charAt(0) && iiiCore(board, word, 0, used, i, j)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    private boolean existCore(char[][] board, String word, int index, int i, int j, boolean[] used) {
//        if (index >= word.length()) {
//            return true;
//        }
//
//        if (i + 1 < board.length && board[i+1][j] == word.charAt(index) && iiiCore(board, word, index, used, i+1, j)) {
//            return true;
//        }
//
//        if (j + 1 < board[0].length && board[i][j+1] == word.charAt(index) && iiiCore(board, word, index, used, i, j+1)) {
//            return true;
//        }
//
//        if (i - 1 >= 0 && board[i-1][j] == word.charAt(index) && iiiCore(board, word, index, used, i-1, j)) {
//            return true;
//        }
//
//        if (j - 1 >= 0 && board[i][j-1] == word.charAt(index) && iiiCore(board, word, index, used, i, j-1)) {
//            return true;
//        }
//
//        return false;
//    }
//
//    private boolean iiiCore(char[][] board, String word, int index, boolean[] used, int i, int j) {
//        int pos = i * board[0].length + j;
//
//        if (used[pos]) {
//            return false;
//        }
//
//        used[pos] = true;
//
//        boolean result = existCore(board, word, index + 1, i, j, used);
//        if (result) {
//            return true;
//        }
//
//        used[pos] = false;
//
//        return false;
//    }

}
