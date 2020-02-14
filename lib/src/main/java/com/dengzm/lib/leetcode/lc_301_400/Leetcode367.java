package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 有效的完全平方数
 * @date 2020/2/14 19:14
 */
public class Leetcode367 {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return num >= 0;
        }

        long left = 2;
        long right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long result = mid * mid;
            if (result == num) {
                return true;
            } else if (result > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
