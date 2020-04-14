package com.dengzm.lib.leetcode.mianshi;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题09. 用两个栈实现队列
 * @date 2020/4/14 12:46
 */
public class Ms009 {
    class CQueue {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        public CQueue() {
            // do nothing
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
