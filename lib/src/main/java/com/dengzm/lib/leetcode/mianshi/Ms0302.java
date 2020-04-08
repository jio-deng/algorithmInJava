package com.dengzm.lib.leetcode.mianshi;

import java.util.Stack;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 03.02. 栈的最小值
 * @date 2020/4/8 11:00
 */
public class Ms0302 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (!min.isEmpty()) {
                x = Math.min(x, min.peek());
            }
            min.push(x);
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
