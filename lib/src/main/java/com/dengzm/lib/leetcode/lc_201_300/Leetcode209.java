package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 长度最小的子数组
 * @date 2020/6/5 12:00
 */
public class Leetcode209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int ans = nums.length;
        int start = 0, end = 0;
        int sum = nums[0];
        if (sum >= s) {
            return 1;
        }

        boolean flag = false;

        while (true) {
            while (sum < s && end < nums.length - 1) {
                end ++;
                sum += nums[end];
            }

            if (sum < s) {
                break;
            }

            while (sum >= s && start <= end) {
                flag = true;
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start ++;
            }
        }

        return flag ? ans : 0;
    }
}
