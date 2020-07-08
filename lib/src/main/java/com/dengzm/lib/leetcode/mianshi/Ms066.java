package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 剑指 Offer 66. 构建乘积数组
 * @date 2020/6/24 8:41
 */
public class Ms066 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }

        int n = a.length;
        int[] b1 = new int[n];
        int[] b2 = new int[n];
        b1[0] = 1;
        b2[n-1] = 1;

        for (int i = 1; i < n; i ++) {
            b1[i] = b1[i-1] * a[i-1];
        }

        for (int i = n-2; i >= 0; i --) {
            b2[i] = b2[i+1] * a[i+1];
        }

        int[] b = new int[n];
        for (int i = 0; i < n; i ++) {
            b[i] = b1[i] * b2[i];
        }

        return b;
    }
}
