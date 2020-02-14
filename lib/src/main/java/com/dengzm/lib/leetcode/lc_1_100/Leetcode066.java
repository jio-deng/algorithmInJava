package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 加一
 * @date 2020/1/26 10:03
 */
public class Leetcode066 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {1};
        }

        boolean plus = true;
        for (int i = digits.length - 1; i >= 0; i --) {
            if (!plus) {
                break;
            }

            if (digits[i] < 9) {
                digits[i] ++;
                plus = false;
            } else {
                digits[i] = 0;
            }
        }

        if (plus) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i ++) {
                result[i] = digits[i - 1];
            }

            return result;
        }

        return digits;
    }
}
