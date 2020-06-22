package com.dengzm.lib.leetcode.lc_1001_1100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最佳观光组合
 * @date 2020/6/17 9:00
 */
public class Leetcode1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int left = A[0], res = Integer.MIN_VALUE;
        for (int j = 1; j < A.length; j ++) {
            res = Math.max(res, left + A[j] - j);
            left = Math.max(left, A[j] + j);
        }
        return res;
    }
}
