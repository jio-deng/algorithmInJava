package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 翻转图像
 * @date 2020/3/10 10:06
 */
public class Leetcode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] a : A) {
            int start = 0, end = a.length - 1;
            while (start <= end) {
                if (start == end) {
                    a[start] = (a[start] + 1) % 2;
                    break;
                }

                a[start] = (a[start] + 1) % 2;
                a[end] = (a[end] + 1) % 2;
                if (a[start] != a[end]) {
                    a[start] = a[start] + a[end] - (a[end] = a[start]);
                }

                start ++;
                end --;
            }
        }

        return A;
    }
}
