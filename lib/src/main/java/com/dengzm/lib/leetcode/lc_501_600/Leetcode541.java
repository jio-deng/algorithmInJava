package com.dengzm.lib.leetcode.lc_501_600;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 反转字符串 II
 * @date 2020/2/21 16:44
 */
public class Leetcode541 {
    public String reverseStr(String s, int k) {
        if (s == null) {
            return null;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += k * 2) {
            int start = i, end = Math.min(chars.length - 1, start + k - 1);
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start ++;
                end --;
            }
//
//
//            if (i + k > chars.length) {
//                k = chars.length - i;
//            }
//
//            for (int j = i; j < i + k / 2; j ++) {
//                char temp = chars[j];
//                chars[j] = chars[2 * i+k-1-j];
//                chars[2 * i+k-1-j] = temp;
//            }
        }

        return String.valueOf(chars);
    }
}
