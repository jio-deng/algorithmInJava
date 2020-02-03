package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 柱状图中最大的矩形
 * @date 2020/2/3 10:54
 */
public class Leetcode084 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;

        // 辅助跳跃用
        int[] left_i = new int[n];
        int[] right_i = new int[n];
        left_i[0] = -1;
        right_i[n - 1] = n;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i]) tmp = left_i[tmp];
            left_i[i] = tmp;
        }
        for (int i = n - 2; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < n && heights[tmp] >= heights[i]) tmp = right_i[tmp];
            right_i[i] = tmp;
        }
        for (int i = 0; i < n; i++) res = Math.max(res, (right_i[i] - left_i[i] - 1) * heights[i]);
        return res;
    }


//    public int largestRectangleArea(int[] heights) {
//        if (heights == null || heights.length == 0) {
//            return 0;
//        }
//
//        int max = 0;
//        for (int i = 0; i < heights.length; i ++) {
//            int left = i;
//            while (left >= 0) {
//                if (heights[left] < heights[i]) {
//                    break;
//                }
//
//                left --;
//            }
//
//            left ++;
//
//            int right = i;
//            while (right < heights.length) {
//                if (heights[right] < heights[i]) {
//                    break;
//                }
//
//                right ++;
//            }
//
//            right --;
//
//            max = Math.max(max, (right - left + 1) * heights[i]);
//        }
//
//        return max;
//    }
}
