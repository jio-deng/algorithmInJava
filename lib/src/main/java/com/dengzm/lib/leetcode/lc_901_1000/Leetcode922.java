package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 按奇偶排序数组 II
 * @date 2020/3/15 9:26
 */
public class Leetcode922 {
    public int[] sortArrayByParityII(int[] A) {
        int ji = 1, ou = 0;

        while (ji < A.length && ou < A.length) {
            while (ji < A.length && A[ji] % 2 == 1) {
                ji += 2;
            }

            while (ou < A.length && A[ou] % 2 == 0) {
                ou += 2;
            }

            if (ji < A.length && ou < A.length) {
                A[ji] = A[ji] + A[ou] - (A[ou] = A[ji]);
                ji += 2;
                ou += 2;
            }
        }

        return A;
    }
}
