package com.dengzm.lib.leetcode.mianshi;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题59 - II. 队列的最大值
 * @date 2020/3/7 8:35
 */
public class Ms059 {
    class MaxQueue {
            private Deque<Integer> queue;
            private Deque<Integer> helper;

            public MaxQueue() {
                queue = new ArrayDeque<>();
                helper = new ArrayDeque<>();
            }

            public int max_value() {
                if (queue.isEmpty()) {
                    return -1;
                }

                return helper.peekFirst();
            }

            public void push_back(int value) {
                queue.addLast(value);
                while (!helper.isEmpty() && value > helper.peekLast()) {
                    helper.pollLast();
                }

                helper.addLast(value);
            }

            public int pop_front() {
                if (queue.isEmpty()) {
                    return -1;
                }

                int val = queue.poll();
                if (val == helper.peekFirst()) {
                    helper.pollFirst();
                }
                return val;
            }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
}
