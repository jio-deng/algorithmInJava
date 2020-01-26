package com.dengzm.lib.leetcode.lc_51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description N皇后 II
 * @date 2020/1/25 10:09
 */
public class Leetcode052 {
    int rows[];
    // "hill" diagonals
    int hills[];
    // "dale" diagonals
    int dales[];
    int n;
    // output
    List<List<String>> output = new ArrayList();
    // queens positions
    int queens[];

    public boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public void placeQueen(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        hills[row - col + 2 * n] = 1;  // "hill" diagonals
        dales[row + col] = 1;   //"dale" diagonals
    }

    public void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                // if n queens are already placed
                if (row + 1 == n) addSolution();
                    // if not proceed to place the rest
                else backtrack(row + 1);
                // backtrack
                removeQueen(row, col);
            }
        }
    }

    public int totalNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return output.size();
    }


    /**-------------------------------------------------------------------***/

    public int totalNQueens1(int n) {
        if (n == 1) {
            return 1;
        }

        if (n < 3) {
            return 0;
        }

        List<List<Integer>> allLists = new ArrayList<>();
        solveQueensCore(n, allLists, new ArrayList<Integer>(), 0);

        return allLists.size();
    }


    private void solveQueensCore(int n, List<List<Integer>> allLists, List<Integer> list, int current) {
        if (current >= n) {
            allLists.add(list);
            return;
        }

        if (current == 0) {
            for (int i = 0; i < n; i ++) {
                List<Integer> l = new ArrayList<>(list);
                l.add(i);
                solveQueensCore(n, allLists, l, current + 1);
            }
        } else {
            int x = current;

            for (int y = 0; y < n; y ++) {
                boolean flag = true;
                for (int i = 0; i < list.size(); i ++) {
                    if (list.get(i) == y || Math.abs(x - i) == Math.abs(list.get(i) - y)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    List<Integer> l = new ArrayList<>(list);
                    l.add(y);
                    solveQueensCore(n, allLists, l, current + 1);
                }

            }

        }
    }
}
