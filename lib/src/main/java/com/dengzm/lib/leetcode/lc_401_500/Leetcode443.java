package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 压缩字符串
 * @date 2020/2/17 11:35
 */
public class Leetcode443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        if (chars.length == 1) {
            return 1;
        }

        int read = 0, write = 0, lastRead = 0;
        while (read <= chars.length) {
            if (read < chars.length && chars[write] == chars[read]) {
                read ++;
            } else {
                int length = read - lastRead;
                // System.out.println(read + "     " + lastRead);
                if (length > 1) {
                    char[] cs = String.valueOf(length).toCharArray();
                    for (char c : cs) {
                        // System.out.println(c + " " + write);
                        chars[++write] = c;
                    }
                }

                if (read < chars.length) {
                    chars[++write] = chars[read];
                }

                lastRead = read;
                read ++;
            }
        }

        return write + 1;
    }
}
