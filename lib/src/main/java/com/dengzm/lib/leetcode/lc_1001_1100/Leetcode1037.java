package com.dengzm.lib.leetcode.lc_1001_1100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 有效的回旋镖
 * @date 2020/3/25 11:26
 */
public class Leetcode1037 {
    public boolean isBoomerang(int[][] points) {
        return (points[0][1] - points[1][1]) * (points[1][0] - points[2][0])
                != (points[0][0] - points[1][0]) * (points[1][1] - points[2][1]);
    }
}
