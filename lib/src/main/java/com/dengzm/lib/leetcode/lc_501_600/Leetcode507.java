package com.dengzm.lib.leetcode.lc_501_600;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 完美数
 * @date 2020/2/21 14:59
 */
public class Leetcode507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 0) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i < Math.sqrt(num); i ++) {
            if (num % i == 0) {
                sum += i;

                int another = num / i;
                if (another != num && another != i) {
                    sum += another;
                }

                if (sum > num) {
                    return false;
                }
            }
        }

        return sum == num;
    }
}
