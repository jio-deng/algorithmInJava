package com.dengzm.lib.leetcode.lc_301_400;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 前 K 个高频元素
 * @date 2020/5/1 13:26
 */
public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<A> priorityQueue = new PriorityQueue<>(new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                return o2.count - o1.count;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            A a = new A(entry.getKey(), entry.getValue());
            priorityQueue.offer(a);
        }

//        List<Integer> ans = new ArrayList<>();

//        while (k > 0) {
//            ans.add(priorityQueue.poll().num);
//            k --;
//        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i ++) {
            ans[i] = priorityQueue.poll().num;
        }

        return ans;
    }

    class A {
        public int num;
        public int count;

        public A(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
