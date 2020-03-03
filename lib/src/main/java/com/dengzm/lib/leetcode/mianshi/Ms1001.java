package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 10.01.合并排序的数组
 * @date 2020/3/3 10:53
 */
public class Ms1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int pos = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (A[index1] > B[index2]) {
                A[pos] = A[index1];
                index1 --;
            } else {
                A[pos] = B[index2];
                index2 --;
            }

            pos --;
        }

        if (index1 >= 0) {
            return;
        }

        while (pos >= 0) {
            A[pos] = B[index2];
            index2 --;
            pos --;
        }
    }
}
