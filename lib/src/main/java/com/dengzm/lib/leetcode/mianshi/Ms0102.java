package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 01.02. 判定是否互为字符重排
 * @date 2020/4/1 14:13
 */
public class Ms0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.length() == 0) {
            return true;
        }

        int[] count = new int[128];
        for (int i = 0; i < s1.length(); i ++) {
            count[s1.charAt(i)] ++;
            count[s2.charAt(i)] --;
        }

        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
