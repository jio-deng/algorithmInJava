package com.dengzm.lib.leetcode.lc_1301_1400;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两个数组间的距离值
 * @date 2020/4/1 13:39
 */
public class Leetcode1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int a : arr1) {
            if (isAllAboveD(a, arr2, d)) {
                ans ++;
            }
        }

        return ans;
    }

    private boolean isAllAboveD(int a, int[] arr, int d) {
        int left = 0, right = arr.length - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == a) {
                return false;
            } else if (arr[mid] > a) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return Math.abs(arr[left] - a) > d && Math.abs(arr[right] - a) > d;
    }
}
