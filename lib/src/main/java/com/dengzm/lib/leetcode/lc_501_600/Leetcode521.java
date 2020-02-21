package com.dengzm.lib.leetcode.lc_501_600;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最长特殊序列 Ⅰ
 * @date 2020/2/21 15:45
 */
public class Leetcode521 {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }

        return Math.max(a.length(), b.length());
    }
}
