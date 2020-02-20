package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 排列硬币
 * @date 2020/2/17 11:16
 */
public class Leetcode441 {
    public int arrangeCoins(int n) {
        long start = 0, end = n;
        while (start < end) {
            long mid = start + (end - start + 1) / 2;
            long t = (1 + mid) * mid / 2;
            if (t == n) {
                return (int)mid;
            } else if (t > n) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }

        return (int)start;
    }

    public int arrangeCoins1(int n) {
        int index = 0;
        while (n > 0) {
            index ++;
            n -= index;
        }

        return n == 0 ? index : index - 1;
    }
}
