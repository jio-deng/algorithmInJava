package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最长回文串
 * @date 2020/2/15 20:06
 */
public class Leetcode409 {
    public int longestPalindrome(String s) {
        int[] nums = new int[128];
        for (int i = 0; i < s.length(); i ++) {
            nums[s.charAt(i)] ++;
        }

        boolean hasExtra = false;
        int result = 0;
        for (int num : nums) {
            if (num > 1) {
                if (num % 2 == 0) {
                    result += num;
                } else {
                    result += num - 1;
                    hasExtra = true;
                }
            } else if (num == 1) {
                hasExtra = true;
            }
        }

        return result + (hasExtra ? 1 : 0);
    }
}
