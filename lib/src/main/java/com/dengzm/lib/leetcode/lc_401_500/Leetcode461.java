package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 汉明距离
 * @date 2020/2/15 18:57
 */
public class Leetcode461 {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int result = 0;
        while (num > 0) {
            result += (num & 1);
            num >>= 1;
        }

        return result;
    }
}
