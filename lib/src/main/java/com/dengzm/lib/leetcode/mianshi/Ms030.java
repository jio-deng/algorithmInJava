package com.dengzm.lib.leetcode.mianshi;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题30. 包含min函数的栈
 * @date 2020/6/11 10:24
 */
public class Ms030 {
    class MinStack {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            min = Math.min(min, x);
            minStack.push(min);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }

        public int top() {
            return stack.peekFirst();
        }

        public int min() {
            return minStack.peekFirst();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
