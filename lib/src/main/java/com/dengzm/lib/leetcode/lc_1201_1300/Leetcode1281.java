package com.dengzm.lib.leetcode.lc_1201_1300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 整数的各位积和之差
 * @date 2020/3/17 9:25
 */
public class Leetcode1281 {
    public int subtractProductAndSum(int n) {
        int muti = 1, plus = 0;
        while (n != 0) {
            int val = n % 10;
            muti *= val;
            plus += val;
            n /= 10;
        }

        return muti - plus;
    }
}
