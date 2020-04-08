package com.dengzm.lib.leetcode.mianshi;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题13. 机器人的运动范围
 * @date 2020/4/8 9:59
 */
public class Ms013 {
    private int[] dx = new int[] {1, -1, 0, 0};
    private int[] dy = new int[] {0, 0, 1, -1};

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }

        int val, row, col;
        int[][] graph = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                val = 0;
                row = i;
                col = j;
                while (row > 0) {
                    val += row % 10;
                    row /= 10;
                }

                while (col > 0) {
                    val += col % 10;
                    col /= 10;
                }

                if (val <= k) {
                    graph[i][j] = 1;
                }
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(0);
        int ans = 0;

//        for (int i = 0; i < m; i ++) {
//            for (int j = 0; j < n; j ++) {
//                System.out.print(graph[i][j]);
//                System.out.print(" ");
//            }
//
//            System.out.println();
//        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (set.contains(v)) {
                continue;
            }

            set.add(v);
            row = v / 1000;
            col = v % 1000;

            if (graph[row][col] == 1) {
                // System.out.println(row + " " + col);
                ans ++;

                for (int i = 0; i < 4; i ++) {
                    int y = row + dy[i];
                    int x = col + dx[i];
                    if (y < 0 || y >= m || x < 0 || x >= n) {
                        continue;
                    }

                    queue.add(y * 1000 + x);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Ms013 ms013 = new Ms013();
        System.out.println(ms013.movingCount(16, 8, 4));
    }
}
