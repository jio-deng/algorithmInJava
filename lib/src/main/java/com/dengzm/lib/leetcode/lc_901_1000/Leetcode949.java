package com.dengzm.lib.leetcode.lc_901_1000;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 给定数字能组成的最大时间
 * @date 2020/3/19 8:16
 */
public class Leetcode949 {
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        for (int i = 3; i >= 0; i --) {
            if (A[i] > 2) {
                continue;
            }

            for (int j = 3; j >= 0; j --) {
                if (j == i || A[i] == 2 && A[j] > 3) {
                    continue;
                }

                for (int k = 3; k >= 0; k --) {
                    if (k == i || k == j || A[k] > 5) {
                        continue;
                    }

                    return "" + A[i] + A[j] + ":" + A[k] + A[6-i-j-k];
                }
            }
        }

        return "";
    }
}
