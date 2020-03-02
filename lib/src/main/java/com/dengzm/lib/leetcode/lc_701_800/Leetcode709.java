package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 转换成小写字母
 * @date 2020/3/2 10:31
 */
public class Leetcode709 {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] += 32;
            }
        }

        return String.valueOf(chars);
    }

    /**
     * 用位运算的技巧
     * 大写变小写、小写变大写 : 字符 ^= 32;
     * 大写变小写、小写变小写 : 字符 |= 32;
     * 小写变大写、大写变大写 : 字符 &= -33;
     *
     * class Solution {
     * public:
     *     string toLowerCase(string str) {
     *         for(auto &i : str){
     *             i |= 32;
     *         }
     *         return str;
     *     }
     * };
     */
}
