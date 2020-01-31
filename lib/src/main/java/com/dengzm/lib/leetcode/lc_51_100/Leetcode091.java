package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 解码方法
 * @date 2020/1/31 8:51
 */
public class Leetcode091 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int[] memo = new int[chars.length + 2];
        return numDecodeingsCore(memo, chars, 0);
    }

    private int numDecodeingsCore(int[] memo, char[] chars, int index) {
        if (index >= chars.length) {
            return 1;
        }

        if (memo[index] != 0) {
            return memo[index];
        }

        int i = chars[index] - '0';
        if (i == 0) {
            return 0;
        }

        int result;
        if (index < chars.length - 1 && (i == 1 || (i == 2 && chars[index+1] - '0' <= 6))) {
            memo[index + 1] = numDecodeingsCore(memo, chars, index + 1);
            memo[index + 2] = numDecodeingsCore(memo, chars, index + 2);
            result = memo[index + 1] + memo[index + 2];
        } else {
            memo[index + 1] = numDecodeingsCore(memo, chars, index + 1);
            result = memo[index + 1];
        }

        return result;
    }
}
