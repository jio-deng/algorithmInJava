package com.dengzm.lib.leetcode.lc_1001_1100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description K 次取反后最大化的数组和
 * @date 2020/3/22 10:40
 */
public class Leetcode1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int a : A) {
            queue.offer(a);
        }

        while (K > 0) {
            queue.offer(-queue.poll());
            K --;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            ans += queue.poll();
        }

        return ans;
    }
}
