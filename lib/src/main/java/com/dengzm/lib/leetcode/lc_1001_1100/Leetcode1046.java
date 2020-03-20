package com.dengzm.lib.leetcode.lc_1001_1100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最后一块石头的重量
 * @date 2020/3/20 12:39
 */
public class Leetcode1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int s : stones) {
            queue.offer(s);
        }

        while (queue.size() >= 2) {
            int bigger = queue.poll();
            int smaller = queue.poll();
            int val = bigger - smaller;
            if (val > 0) {
                queue.offer(val);
            }
        }

        if (queue.size() == 0) {
            return 0;
        }

        return queue.poll();
    }
}
