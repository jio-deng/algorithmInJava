package com.dengzm.lib.leetcode.lc_1001_1100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 十进制整数的反码
 * @date 2020/3/24 9:55
 */
public class Leetcode1009 {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int ans = 0;
        int mask = 0;
        while (N > 0) {
            int b = N % 2;
            ans += (b ^ 1) << mask;
            mask ++;
            N >>= 1;
        }

        return ans;
    }
}
