package com.dengzm.lib.leetcode.lc_301_400;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两个数组的交集 II
 * @date 2020/2/14 19:14
 */
public class Leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;

        int[] result = new int[nums1.length];
        int length = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                result[length] = nums1[index1];
                length ++;
                index1 ++;
                index2 ++;
            } else if (nums1[index1] > nums2[index2]) {
                index2 ++;
            } else {
                index1 ++;
            }
        }

        return Arrays.copyOf(result, length);
    }
}
