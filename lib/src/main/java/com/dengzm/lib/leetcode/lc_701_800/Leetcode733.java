package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 图像渲染
 * @date 2020/3/4 11:36
 */
public class Leetcode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if (target != newColor) {
            dfs(image, sr, sc, target, newColor);
        }

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int target, int newColor) {
        if (image[sr][sc] != target) {
            return;
        }

        image[sr][sc] = newColor;

        if (sr > 0) {
            dfs(image, sr - 1, sc, target, newColor);
        }

        if (sr < image.length - 1) {
            dfs(image, sr + 1, sc, target, newColor);
        }

        if (sc > 0) {
            dfs(image, sr, sc - 1, target, newColor);
        }

        if (sc < image[0].length - 1) {
            dfs(image, sr, sc + 1, target, newColor);
        }
    }
}
