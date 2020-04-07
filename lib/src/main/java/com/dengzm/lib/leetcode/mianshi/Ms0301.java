package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 03.01. 三合一
 * @date 2020/4/6 11:08
 */
public class Ms0301 {
    class TripleInOne {
        int[] stack;
        int[] stackTop;
        int stackSize;

        public TripleInOne(int stackSize) {
            stack = new int[stackSize * 3];
            stackTop = new int[] {0,1,2};
            this.stackSize = stackSize;
        }

        public void push(int stackNum, int value) {
            int cur = stackTop[stackNum];
            if (cur >= stackSize * 3) {
                return;
            }

            stack[cur] = value;
            stackTop[stackNum] += 3;
        }

        public int pop(int stackNum) {
            if (isEmpty(stackNum)) {
                return -1;
            }

            int val = stack[stackTop[stackNum] - 3];
            stackTop[stackNum] -= 3;
            return val;
        }

        public int peek(int stackNum) {
            if (isEmpty(stackNum)) {
                return -1;
            }

            return stack[stackTop[stackNum] - 3];
        }

        public boolean isEmpty(int stackNum) {
            return stackTop[stackNum] < 3;
        }
    }

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
}
