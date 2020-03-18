package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 有效的山脉数组
 * @date 2020/3/18 10:01
 */
public class Leetcode941 {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }

        int index = -1;
        for (int i = 1; i < A.length - 1; i ++) {
            if (A[i] > A[i-1]) {
                index = i;
            } else {
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        for (int i = A.length - 1; i > index; i --) {
            if (A[i] >= A[i-1]) {
                return false;
            }
        }

        return true;
    }
}
