package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 非递减数列
 * @date 2020/2/29 10:25
 */
public class Leetcode665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }

        int count = 0;
        if (nums[0] > nums[1]) {
            nums[0] = nums[1];
            count ++;
        }

        for (int i = 1; i < nums.length - 1; i ++) {
            int right = nums[i+1];
            if (nums[i] > right) {
                count ++;
                if (count > 1) {
                    return false;
                }

                int left = nums[i-1];
                if (left > right) {
                    nums[i+1] = nums[i];
                } else {
                    nums[i] = left;
                }
            }
        }

        return true;
    }
}
