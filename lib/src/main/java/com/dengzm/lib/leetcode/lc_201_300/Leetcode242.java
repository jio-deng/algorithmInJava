package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 有效的字母异位词
 * @date 2020/2/14 10:48
 */
public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] nums = new int[128];
        for (int i = 0; i < s.length(); i ++) {
            nums[s.charAt(i)] ++;
            nums[t.charAt(i)] --;
        }

        for (int i : nums) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
