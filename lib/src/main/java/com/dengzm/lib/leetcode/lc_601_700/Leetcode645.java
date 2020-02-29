package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 错误的集合
 * @date 2020/2/28 10:31
 */
public class Leetcode645 {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            int correctNum = i + 1;
            while (nums[i] != correctNum) {
                int n = nums[i];
                if (nums[n-1] == n) {
                    break;
                }
                nums[i] = nums[n-1];
                nums[n-1] = n;
            }
        }

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != i + 1) {
                ans[0] = nums[i];
                ans[1] = i + 1;
                break;
            }
        }

        return ans;
    }
}
