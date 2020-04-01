package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 01.01. 判定字符是否唯一
 * @date 2020/4/1 14:10
 */
public class Ms0101 {
    public boolean isUnique(String astr) {
        int mask = 0;
        for (char c : astr.toCharArray()) {
            int b = 1 << (c - 'a');
            if ((mask & b) > 0) {
                return false;
            }

            mask += b;
        }

        return true;
    }
}
