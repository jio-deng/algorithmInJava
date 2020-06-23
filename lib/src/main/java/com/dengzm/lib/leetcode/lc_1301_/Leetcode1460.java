package com.dengzm.lib.leetcode.lc_1301_;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 通过翻转子数组使两个数组相等
 * @date 2020/6/23 11:58
 */
public class Leetcode1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i ++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }

        return true;
    }
}
