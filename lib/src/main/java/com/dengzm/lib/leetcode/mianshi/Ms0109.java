package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 01.09. 字符串轮转
 * @date 2020/4/4 10:26
 */
public class Ms0109 {
    public boolean isFlipedString(String s1, String s2) {
        return s2.length() == s1.length() && (s2 + s2).contains(s1);
    }
}
