package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 验证回文字符串 Ⅱ
 * @date 2020/2/29 11:47
 */
public class Leetcode680 {
    public boolean validPalindrome(String s) {
        return validPalindromeCore(s, 0, s.length() - 1, 1);
    }

    private boolean validPalindromeCore(String s, int start, int end, int maxDelCount) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start ++;
                end --;
            } else {
                if (maxDelCount == 0) {
                    return false;
                } else {
                    return validPalindromeCore(s, start + 1, end, maxDelCount - 1) ||
                            validPalindromeCore(s, start, end - 1, maxDelCount - 1);
                }
            }
        }

        return true;
    }
}
