package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 删列造序
 * @date 2020/3/18 11:10
 */
public class Leetcode944 {
    public int minDeletionSize(String[] A) {
        int ans = 0;
        for (int i = 0; i < A[0].length(); i ++) {
            char pre = 'a' - 1;
            for (String s : A) {
                if (s.charAt(i) < pre) {
                    ans ++;
                    break;
                }

                pre = s.charAt(i);
            }
        }

        return ans;
    }
}
