package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 338. 比特位计数
 * @date 2020/4/13 11:53
 */
public class Leetcode338 {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[] {0};
        }

        int[] dp = new int[num + 1];
        dp[1] = 1;

        for (int i = 2; i <= num; i ++) {
            int a = dp[i-1];
            int mask = 1;
            while (true) {
                if (((i-1) & mask) > 0) {
                    a --;
                    mask <<= 1;
                } else {
                    a ++;
                    break;
                }
            }

            dp[i] = a;
        }

        return dp;
    }

    public static void main(String[] args) {
        Leetcode338 leetcode338 = new Leetcode338();
        leetcode338.countBits(4);
    }
}
