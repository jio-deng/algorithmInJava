package com.dengzm.lib.jianzhi;

import java.util.Stack;

/**
 * @Description 030 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能得到栈的最小元素的min函数，且时间复杂度为O(1)
 *
 * Created by deng on 2019/5/21.
 */
public class Jianzhi030 {

    public static void main(String[] args) {
        StackWithMin<Integer> stackWithMin = new StackWithMin<>();
        stackWithMin.push(3);
        stackWithMin.push(4);
        stackWithMin.push(0);
        stackWithMin.push(2);
        stackWithMin.push(1);
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
    }

    private static class StackWithMin<T extends Comparable> {
        private Stack<T> mData;
        private Stack<T> mMin;

        public StackWithMin() {
            mData = new Stack<>();
            mMin = new Stack<>();
        }

        public T pop() {
            mMin.pop();
            return mData.pop();
        }

        public T push(T data) {
            if (mMin.isEmpty()) {
                mMin.push(data);
            } else {
                T min = mMin.peek();
                if (data.compareTo(min) < 0) {
                    mMin.push(data);
                } else {
                    mMin.push(min);
                }
            }

            return mData.push(data);
        }

        public T min() {
            return mMin.peek();
        }
    }
}
