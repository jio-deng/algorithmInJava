package com.dengzm.lib.leetcode.lc_201_300;

import java.util.Stack;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 用栈实现队列
 * @date 2020/2/14 9:59
 */
public class Leetcode232 {
    class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack2.isEmpty() && stack1.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
