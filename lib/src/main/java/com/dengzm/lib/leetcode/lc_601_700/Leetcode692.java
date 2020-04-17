package com.dengzm.lib.leetcode.lc_601_700;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 前K个高频单词
 * @date 2020/4/17 18:46
 */
public class Leetcode692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        if (k <= 0) {
            return ans;
        }

        PriorityQueue<A> priorityQueue = new PriorityQueue<>(new Comparator<A>() {
            @Override
            public int compare(A a1, A a2) {
                return a2.times != a1.times ? a2.times - a1.times : a1.key.compareTo(a2.key);
            }
        });

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            A a = new A(entry.getKey(), entry.getValue());
            priorityQueue.offer(a);
        }

        while (k > 0 && !priorityQueue.isEmpty()) {
            A a = priorityQueue.poll();
            ans.add(a.key);
            k --;
        }

        return ans;
    }

    class A {
        public String key;
        public int times;

        public A(String key, int times) {
            this.key = key;
            this.times = times;
        }
    }
}
