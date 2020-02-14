package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 反转字符串中的元音字母
 * @date 2020/2/14 18:45
 */
public class Leetcode345 {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;

        char[] chars = s.toCharArray();

        while (left < right) {
            if (isYuanyin(chars[left]) && isYuanyin(chars[right])) {
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left ++;
                right --;
                continue;
            }

            while (left < chars.length && !isYuanyin(chars[left])) {
                left ++;
            }

            while (right >= 0 && !isYuanyin(chars[right])) {
                right --;
            }
        }

        return String.valueOf(chars);
    }

    private boolean isYuanyin(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
