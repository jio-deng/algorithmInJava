package com.dengzm.lib.leetcode.mianshi;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题40. 最小的k个数
 * @date 2020/3/20 10:40
 */
public class Ms040 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[] {};
        }

        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }

        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;

        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);

            if (i >= j) {
                break;
            }

            nums[i] = nums[i] + nums[j] - (nums[j] = nums[i]);
        }

        nums[lo] = nums[j];
        nums[j] = v;

        return j;
    }
}
