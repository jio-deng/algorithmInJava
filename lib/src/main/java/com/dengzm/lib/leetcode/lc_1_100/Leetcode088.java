package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 合并两个有序数组
 * @date 2020/1/31 8:28
 */
public class Leetcode088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int curIndex = length;

        m = m - 1;
        n = n - 1;

        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[curIndex] = nums1[m];
                m --;
            } else {
                nums1[curIndex] = nums2[n];
                n --;
            }

            curIndex --;
        }

        if (m >= 0) {
            return;
        }

        while (curIndex >= 0 && n >= 0) {
            nums1[curIndex] = nums2[n];
            curIndex --;
            n --;
        }
    }
}
