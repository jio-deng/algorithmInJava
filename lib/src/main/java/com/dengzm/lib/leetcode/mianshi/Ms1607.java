package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 16.07. 最大数值
 * @date 2020/4/8 11:04
 */
public class Ms1607 {
    public int maximum(int a, int b) {
        return (((long)a - b) >> 63) == 0 ? a : b;
    }
}
