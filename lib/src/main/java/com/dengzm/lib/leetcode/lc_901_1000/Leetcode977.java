package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 有序数组的平方
 * @date 2020/3/20 11:32
 */
public class Leetcode977 {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int start = 0, end = A.length - 1, index = A.length - 1;
        while (index >= 0) {
            int val1 = A[start] * A[start];
            int val2 = A[end] * A[end];
            if (val1 > val2) {
                ans[index] = val1;
                start ++;
            } else {
                ans[index] = val2;
                end --;
            }

            index --;
        }

        return ans;
    }
}
