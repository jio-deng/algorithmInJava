package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 旋转字符串
 * @date 2020/3/7 9:48
 */
public class Leetcode796 {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (B+B).contains(A);
    }
}
