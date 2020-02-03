package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最大矩形
 * @date 2020/2/3 11:50
 */
public class Leetcode085 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        // init height
        int[][] height = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = matrix[0].length - 1; j >= 0; j --) {
                if (j == matrix[0].length - 1) {
                    height[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    if (matrix[i][j] == '0') {
                        height[i][j] = 0;
                    } else {
                        height[i][j] = height[i][j+1] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < matrix[0].length; i ++) {
            max = Math.max(max, largestRectangleArea(height, i));
        }

        return max;
    }

    public int largestRectangleArea(int[][] heights, int index) {
        int n = heights.length;

        // 辅助跳跃用
        int[] left_i = new int[n];
        int[] right_i = new int[n];
        left_i[0] = -1;
        right_i[n - 1] = n;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp][index] >= heights[i][index]) tmp = left_i[tmp];
            left_i[i] = tmp;
        }
        for (int i = n - 2; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < n && heights[tmp][index] >= heights[i][index]) tmp = right_i[tmp];
            right_i[i] = tmp;
        }
        for (int i = 0; i < n; i++) res = Math.max(res, (right_i[i] - left_i[i] - 1) * heights[i][index]);
        return res;
    }
}
