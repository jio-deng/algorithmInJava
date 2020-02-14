package com.dengzm.lib.leetcode.lc_301_400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两个数组的交集
 * @date 2020/2/14 19:04
 */
public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num1 : nums1) {
            set1.add(num1);
        }

        for (int num2 : nums2) {
            set2.add(num2);
        }

        int[] result = new int[set1.size()];
        int length = 0;

        for (int num : set2) {
            if (set1.contains(num)) {
                result[length] = num;
                length ++;
            }
        }

        return Arrays.copyOf(result, length);
    }
}
