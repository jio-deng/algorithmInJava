package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题53 - II. 0～n-1中缺失的数字
 * @date 2020/2/14 11:52
 */
public class Ms053 {
    public int missingNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }

        for (int i = 0; i < nums.length; i ++) {
            while (nums[i] != i && nums[i] < nums.length) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}
