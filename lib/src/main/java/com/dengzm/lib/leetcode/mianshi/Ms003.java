package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题03. 数组中重复的数字
 * @date 2020/4/14 12:03
 */
public class Ms003 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            while (nums[i] != i) {
                int tmp = nums[nums[i]];
                if (nums[i] == tmp) {
                    return tmp;
                }
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }

        return -1;
    }
}
