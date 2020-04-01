package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 01.04. 回文排列
 * @date 2020/4/1 14:20
 */
public class Ms0104 {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c] ++;
        }

        boolean found = false;
        for (int c : count) {
            if (c % 2 == 1) {
                if (found) {
                    return false;
                } else {
                    found = true;
                }
            }
        }

        return true;
    }
}
