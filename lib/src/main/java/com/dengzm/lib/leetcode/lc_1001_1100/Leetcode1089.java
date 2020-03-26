package com.dengzm.lib.leetcode.lc_1001_1100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 复写零
 * @date 2020/3/26 10:18
 */
public class Leetcode1089 {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        for (int a : arr) {
            if (a == 0) {
                len ++;
            }
        }

        if (len == arr.length) {
            return;
        }

        int curIndex = len - 1, index = arr.length - 1;
        while (curIndex >= 0 && index >= 0) {
            if (arr[index] != 0) {
                if (curIndex < arr.length) {
                    arr[curIndex] = arr[index];
                }
                curIndex --;
            } else {
                if (curIndex < arr.length) {
                    arr[curIndex] = arr[index];
                }
                curIndex --;

                if (curIndex < arr.length) {
                    arr[curIndex] = arr[index];
                }
                curIndex --;
            }

            index --;
        }
    }
}
