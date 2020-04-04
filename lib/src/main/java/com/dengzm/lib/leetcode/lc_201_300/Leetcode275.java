package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description H指数 II
 * @date 2020/4/4 9:30
 */
public class Leetcode275 {
    public int hIndex(int[] citations) {
        for (int i = 0; i < citations.length; i ++) {
            int h = citations.length - i;
            if (h <= citations[i]) {
                return h;
            }
        }

        return 0;
    }
}
