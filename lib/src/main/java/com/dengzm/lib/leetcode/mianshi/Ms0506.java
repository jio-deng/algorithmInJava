package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 05.06. 整数转换
 * @date 2020/4/22 21:11
 */
public class Ms0506 {
    public int convertInteger(int A, int B) {
        int ans = 0;
        int n = A ^ B;
        while (n != 0) {
            n &= (n-1);
            ans ++;
        }

        return ans;
    }
}
