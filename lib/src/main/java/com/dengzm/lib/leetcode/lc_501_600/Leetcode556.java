package com.dengzm.lib.leetcode.lc_501_600;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 下一个更大元素 III
 * @date 2020/3/27 11:09
 */
public class Leetcode556 {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i > 0; i --) {
            if (chars[i] > chars[i-1]) {
                int j;
                for (j = i; j < chars.length; j ++) {
                    if (chars[i-1] >= chars[j]) {
                        char tmp = chars[i-1];
                        chars[i-1] = chars[j-1];
                        chars[j-1] = tmp;
                        break;
                    }
                }

                if (j == chars.length) {
                    char tmp = chars[i-1];
                    chars[i-1] = chars[chars.length - 1];
                    chars[chars.length - 1] = tmp;
                }

                int start = i, end = chars.length - 1;
                while (start < end) {
                    char tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;
                    start ++;
                    end --;
                }

                try {
                    return Integer.parseInt(String.valueOf(chars));
                } catch (Exception e) {
                    return -1;
                }
            }
        }

        return -1;
    }
}
