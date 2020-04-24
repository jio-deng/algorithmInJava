package com.dengzm.lib.leetcode.mianshi;

import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 08.10. 颜色填充
 * @date 2020/4/23 19:18
 */
public class Ms0810 {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length, m = image[0].length;
        boolean[][] isVisited = new boolean[n][m];

        int color = image[sr][sc];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(sr * 100 + sc);

        while (!queue.isEmpty()) {
            int val = queue.poll();
            int y = val / 100, x = val % 100;
            if (isVisited[y][x]) {
                continue;
            }

            isVisited[y][x] = true;
            if (image[y][x] == color) {
                image[y][x] = newColor;

                for (int i = 0; i < 4; i ++) {
                    int ny = y + dy[i], nx = x + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                        continue;
                    }

                    queue.add(ny * 100 + nx);
                }
            }
        }

        return image;
    }
}
