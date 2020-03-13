package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 按奇偶排序数组
 * @date 2020/3/12 16:59
 */
public class Leetcode905 {
    public int[] sortArrayByParity(int[] A) {
        int start = 0, end = A.length - 1;
        while (start < end) {
            while (start < end && A[start] % 2 == 0) {
                start ++;
            }

            while (end > start && A[end] % 2 == 1) {
                end --;
            }

            if (start < end) {
                A[start] = A[start] + A[end] - (A[end] = A[start]);
                start ++;
                end --;
            }
        }

        return A;
    }
}
