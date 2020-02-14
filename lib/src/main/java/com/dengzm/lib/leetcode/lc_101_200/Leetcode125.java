package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 验证回文串
 * @date 2020/2/7 20:03
 */
public class Leetcode125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            while (left < chars.length &&
                    (chars[left] < '0' ||
                            (chars[left] > '9' && chars[left] < 'A') ||
                            (chars[left] > 'Z' && chars[left] < 'a') ||
                            chars[left] > 'z')) {
                left ++;
            }

            while (right >= 0 &&
                    (chars[right] < '0' ||
                            (chars[right] > '9' && chars[right] < 'A') ||
                            (chars[right] > 'Z' && chars[right] < 'a') ||
                            chars[right] > 'z')) {
                right --;
            }

            if (left >= right) {
                return true;
            } else if (chars[left] != chars[right]) {
                return false;
            }

            left ++;
            right --;
        }

        return true;
    }
}
