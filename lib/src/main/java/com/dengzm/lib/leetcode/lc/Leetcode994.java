package com.dengzm.lib.leetcode.lc;

import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 腐烂的橘子
 * @date 2020/3/4 10:02
 */
public class Leetcode994 {
    private static final int[] dx = new int[] {0, 1, -1, 0, 0};
    private static final int[] dy = new int[] {0, 0, 0, 1, -1};

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int n = grid.length, m = grid[0].length;
        LinkedList<Pair> queue = new LinkedList<>();
        for (int r = 0; r < n; r ++) {
            for (int c = 0; c < m; c ++) {
                if (grid[r][c] == 2) {
                    queue.add(new Pair(0, r * m + c));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.pop();
            int r = pair.pos / m, c = pair.pos % m;
            if (pair.minutes != 0 && grid[r][c] != 1) {
                continue;
            }

            grid[r][c] = 2;
            ans = Math.max(pair.minutes, ans);

            for (int k = 1; k <= 4; k ++) {
                int nr = r + dy[k], nc = c + dx[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (grid[nr][nc] == 1) {
                    queue.add(new Pair(pair.minutes + 1, nr * m + nc));
                }
            }
        }

        for (int[] ints : grid) {
            for (int c : ints) {
                if (c == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }

    class Pair {
        public int minutes;
        public int pos;

        public Pair(int minutes, int pos) {
            this.minutes = minutes;
            this.pos = pos;
        }
    }
}
