package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description x 的平方根
 * @date 2020/1/27 15:53
 */
public class Leetcode069 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        if (x < 4) {
            return 1;
        }

        return (int) mySqrtCore(x, 1, x / 2);
    }

    private long mySqrtCore(int x, long start, long end) {
        if (start >= end) {
            return start;
        }

        long mid = (start + end + 1) / 2;
        if (mid * mid == x) {
            return mid;
        } else if (mid * mid > x) {
            return mySqrtCore(x, start, mid - 1);
        } else {
            return mySqrtCore(x, mid, end);
        }
    }
}
