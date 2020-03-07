package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 连续整数求和
 * @date 2020/3/6 9:48
 */
public class Leetcode829 {
    public int consecutiveNumbersSum(int N) {
        int result = 1;
        if (N <= 2) {
            return result;
        }

        for (int i = 2; i < N; i ++) {
            int tmp = N / i;

            // 因数是双数，则需要满足（tmp + tmp + 1）* num / 2 == target
            // 因数是单数，则需要满足 tmp * num == target
            if (i % 2 == 0 && (tmp * 2 + 1) * i / 2 == N ||
                    i % 2 != 0 && tmp * i == N) {

                // 判断长度是否足够
                if (tmp <= (i - 1) / 2) {
                    break;
                }

                result ++;
            }
        }

        return result;
    }
}
