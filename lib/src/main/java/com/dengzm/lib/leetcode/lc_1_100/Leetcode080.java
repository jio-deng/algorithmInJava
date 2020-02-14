package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 删除排序数组中的重复项 II
 * @date 2020/1/29 12:08
 */
public class Leetcode080 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length < 3) {
            return nums.length;
        }

        int newLength = 1;
        int curNum = nums[0];
        int curLength = 1;

        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == curNum) {
                if (curLength == 2) {
                    // do nothing
                } else {
                    nums[newLength] = nums[i];

                    curLength ++;
                    newLength ++;
                }
            } else {
                curNum = nums[i];
                curLength = 1;

                nums[newLength] = nums[i];
                newLength ++;
            }
        }

        return newLength;
    }
}
