package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 05.03. 翻转数位
 * @date 2020/4/22 21:22
 */
public class Ms0503 {
    public int reverseBits(int num) {
        if (num == 0) {
            return 1;
        }
        int ans = 0;

        int cur = 0, next = 0, times = 32;
        boolean isNext = false;

        while (times -- > 0) {
            int val = num & 1;
            if (val == 1) {
                cur ++;
                if (isNext) {
                    next ++;
                }
            } else {
                if (!isNext) {
                    isNext = true;
                    cur ++;
                } else {
                    cur = next + 1;
                    next = 0;
                }
            }

            ans = Math.max(ans, cur);
            num >>= 1;
        }

        return ans;
    }
}
