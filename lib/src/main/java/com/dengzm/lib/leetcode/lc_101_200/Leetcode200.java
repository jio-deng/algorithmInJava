package com.dengzm.lib.leetcode.lc_101_200;

import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 岛屿数量
 * @date 2020/4/20 10:07
 */
public class Leetcode200 {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        char ans = '2';
        int n = grid.length, m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];
        LinkedList<A> queue = new LinkedList<>();

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                queue.add(new A(i, j));
                boolean flag = false;

                while (!queue.isEmpty()) {
                    A a = queue.poll();
                    if (grid[a.y][a.x] == '0' || isVisited[a.y][a.x]) {
                        continue;
                    }

                    flag = true;
                    isVisited[a.y][a.x] = true;
                    grid[a.y][a.x] = ans;

                    for (int q = 0; q < 4; q ++) {
                        int ny = a.y + dy[q];
                        int nx = a.x + dx[q];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                            continue;
                        }

                        queue.add(new A(ny, nx));
                    }
                }

                if (flag) {
                    ans ++;
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        return ans - '2';
    }

    class A {
        public int y;
        public int x;

        public A(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
