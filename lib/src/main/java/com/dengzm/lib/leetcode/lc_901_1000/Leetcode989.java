package com.dengzm.lib.leetcode.lc_901_1000;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数组形式的整数加法
 * @date 2020/3/20 11:46
 */
public class Leetcode989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; i --) {
            int val = A[i] + K % 10;
            res.addFirst(val % 10);
            K = K / 10 + (val >= 10 ? 1 : 0);
        }

        while (K > 0) {
            res.addFirst(K % 10);
            K /= 10;
        }

        return res;
    }
}
