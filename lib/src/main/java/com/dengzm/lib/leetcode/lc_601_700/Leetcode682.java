package com.dengzm.lib.leetcode.lc_601_700;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 棒球比赛
 * @date 2020/2/29 11:52
 */
public class Leetcode682 {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : ops) {
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("+")) {
                int top = stack.pop();
                int sec = stack.pop();
                stack.push(sec);
                stack.push(top);
                stack.push(top + sec);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
