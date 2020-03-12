package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 单调数列
 * @date 2020/3/12 13:00
 */
public class Leetcode896 {
    public boolean isMonotonic(int[] A) {
        boolean isUp = true, isDown = true;

        for (int i = 0; i < A.length; i ++) {
            if (i == 0 || A[i] == A[i - 1]) {
                continue;
            }

            if (A[i] > A[i-1]) {
                if (!isUp) {
                    return false;
                }

                isDown = false;
            } else {
                if (!isDown) {
                    return false;
                }

                isUp = false;
            }
        }

        return true;
    }
}
