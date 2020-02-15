package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 赎金信
 * @date 2020/2/15 9:48
 */
public class Leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[128];

        for (int i = 0; i < magazine.length(); i ++) {
            chars[magazine.charAt(i)] ++;
        }

        for (int i = 0; i < ransomNote.length(); i ++) {
            chars[ransomNote.charAt(i)] --;

            if (chars[ransomNote.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }
}
