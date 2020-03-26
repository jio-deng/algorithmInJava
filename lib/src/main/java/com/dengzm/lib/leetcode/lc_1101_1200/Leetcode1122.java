package com.dengzm.lib.leetcode.lc_1101_1200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数组的相对排序
 * @date 2020/3/26 10:51
 */
public class Leetcode1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] target = new int[1001];
        int[] res = new int[arr1.length];
        for (int i : arr1) {
            target[i] ++;
        }

        int index = 0;
        for (int i: arr2) {
            while (target[i] > 0) {
                res[index ++] = i;
                target[i] --;
            }
        }

        for (int i = 0; i < target.length; i ++) {
            if (index == res.length) {
                break;
            }

            while (target[i] > 0) {
                res[index ++] = i;
                target[i] --;
            }
        }

        return res;
    }
}
