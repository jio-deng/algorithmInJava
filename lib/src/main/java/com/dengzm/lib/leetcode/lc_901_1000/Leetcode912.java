package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 排序数组
 * @date 2020/3/31 16:02
 */
public class Leetcode912 {
    /**
     * 冒泡
     * @param nums
     * @return
     */
    public int[] sortArray1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i ++) {
            int val = nums[i];
            for (int j = i+1; j < nums.length; j ++) {
                if (nums[j] < val) {
                    int tmp = nums[j];
                    nums[j] = val;
                    val = tmp;
                }
            }

            nums[i] = val;
        }

        return nums;
    }
}
