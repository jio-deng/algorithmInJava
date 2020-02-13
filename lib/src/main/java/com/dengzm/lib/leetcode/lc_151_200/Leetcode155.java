package com.dengzm.lib.leetcode.lc_151_200;

import java.util.Stack;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最小栈
 * @date 2020/2/13 9:28
 */
public class Leetcode155 {
    class MinStack {
        Stack<Integer> data;

        /** initialize your data structure here. */
        public MinStack() {
            data = new Stack<>();
        }

        public void push(int x) {
            if (data.isEmpty()) {
                data.push(x);
                data.push(x);
            } else {
                int temp = data.peek();
                data.push(x);
                if (temp < x) {
                    data.push(temp);
                } else {
                    data.push(x);
                }
            }
        }

        public void pop() {
            data.pop();
            data.pop();
        }

        public int top() {
            return data.get(data.size() - 2);
        }

        public int getMin() {
            return data.peek();
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
