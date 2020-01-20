package com.dengzm.lib.leetcode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 接雨水
 * @date 2020/1/18 14:06
 */
public class Leetcode042 {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i ++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i --) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int result = 0;
        for (int i = 1; i < height.length - 1; i ++) {
            result += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return result;
    }


//    public int trap(int[] height) {
//        if (height == null || height.length <= 1) {
//            return 0;
//        }
//
//        // get max
//        int max = 0;
//        for (int i : height) {
//            if (i > max) {
//                max = i;
//            }
//        }
//
//        // init data
////        int[][] graphs = new int[max][height.length];
////        for (int i = 0; i < height.length; i ++) {
////            int h = height[i];
////            if (h > 0) {
////                for (int j = 0; j < h; j ++) {
////                    graphs[j][i] = 1;
////                }
////            }
////        }
//
//        int result = 0;
//
//        for (int i = 0; i < max; i ++) {
////            int[] graph = graphs[i];
//            int start = -1, end = -1, count = 0;
//
//            for (int j = 0; j < height.length; j ++) {
//                if (height[j] >= i + 1) {
//                    count ++;
//                    if (start == -1) {
//                        start = j;
//                    } else {
//                        end = j;
//                    }
//                }
//            }
//
//            if (count >= 2) {
//                result += (end - start - 1 - (count - 2));
//            }
//        }
//
//        return result;
//    }
}
