package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题21. 调整数组顺序使奇数位于偶数前面
 * @date 2020/5/9 17:33
 */
public class Ms021 {
    public int[] exchange(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < nums.length && nums[start] % 2 != 0) {
                start ++;
            }

            while (0 < end && nums[end] % 2 == 0) {
                end --;
            }

            if (start < end) {
                nums[end] = nums[end] + nums[start] - (nums[start] = nums[end]);
                start ++;
                end --;
            }
        }

        return nums;
    }
}
