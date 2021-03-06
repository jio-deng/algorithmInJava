package com.dengzm.lib.leetcode.lc_201_300;

import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 用队列实现栈
 * @date 2020/2/14 9:13
 */
public class Leetcode225 {
    class MyStack {

        LinkedList<Integer> queue1;
        LinkedList<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue1.offer(x);
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }

            LinkedList<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue2.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue2.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue2.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
