package com.dengzm.lib.leetcode;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 下一个排列
 * @date 2020/1/15 10:28
 */
public class Leetcode031 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int find = -1;
        for (int i = nums.length - 1; i > 0; i --) {
            if (nums[i] > nums[i - 1]) {
                find = i - 1;
                break;
            }
        }

        if (find == -1) {
            Arrays.sort(nums);
        } else {
            int cur = nums[find];
            int find2 = 0;
            for (int i = find + 1; i < nums.length; i ++) {
                if (nums[i] > cur) {
                    find2 = i;
                } else {
                    break;
                }
            }

            nums[find] = nums[find2];
            nums[find2] = cur;

            Arrays.sort(nums, find + 1, nums.length);
        }
    }
}
