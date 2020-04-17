package com.dengzm.lib.leetcode.lc_601_700;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 函数的独占时间
 * @date 2020/4/17 14:24
 */
public class Leetcode636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];

        Deque<A> stack = new ArrayDeque<>();
        for (String log : logs) {
            String[] ss = log.split(":");
            int id = Integer.valueOf(ss[0]);
            int time = Integer.valueOf(ss[2]);
            if (ss[1].equals("start")) {
                stack.push(new A(id, time));
            } else {
                A a = stack.pop();
                int realTime =  time - a.time + 1;
                ans[id] += realTime;

                if (!stack.isEmpty()) {
                    ans[stack.peek().id] -= realTime;
                }
            }
        }

        return ans;
    }

    class A {
        public int id;
        public int time;

        public A(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}
