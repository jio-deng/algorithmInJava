package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 山脉数组的峰顶索引
 * @date 2020/3/11 10:40
 */
public class Leetcode852 {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length - 1; i ++) {
            if (A[i] > A[i + 1]) {
                return i;
            }
        }

        return -1;
    }
}
