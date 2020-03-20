package com.dengzm.lib.leetcode.lc_901_1000;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 三角形的最大周长
 * @date 2020/3/20 11:29
 */
public class Leetcode976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        for (int i = A.length - 3; i >= 0; i --) {
            if (A[i] + A[i+1] > A[i+2]) {
                return A[i] + A[i+1] + A[i+2];
            }
        }

        return 0;
    }
}
