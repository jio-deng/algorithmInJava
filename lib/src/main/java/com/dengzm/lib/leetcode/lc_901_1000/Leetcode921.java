package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 使括号有效的最少添加
 * @date 2020/4/16 9:45
 */
public class Leetcode921 {
    public int minAddToMakeValid(String S) {
        int ans = 0;
        int left = 0;
        int right = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                left ++;
            } else {
                right ++;
                if (right > left) {
                    ans ++;
                    right --;
                }
            }
        }

        if (left > right) {
            ans += (left - right);
        }

        return ans;
    }
}
