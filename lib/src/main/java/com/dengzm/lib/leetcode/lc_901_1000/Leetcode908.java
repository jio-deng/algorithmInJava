package com.dengzm.lib.leetcode.lc_901_1000;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最小差值 I
 * @date 2020/3/12 17:04
 */
public class Leetcode908 {
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) {
            return 0;
        }

        Arrays.sort(A);
        int min = A[0] + K;
        int max = A[A.length - 1] - K;

        if (min >= max) {
            return 0;
        }

        return max - min;
    }
}
