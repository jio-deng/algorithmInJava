package com.dengzm.lib;

import java.util.Stack;

/**
 * @Description 031 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是某栈的压栈序列。
 *
 * Created by deng on 2019/5/21.
 */
public class Jianzhi031 {

    public static void main(String[] args) {
        int[] push = new int[] {1,2,3,4,5};
        int[] pop1 = new int[] {4,5,3,2,1};
        int[] pop2 = new int[] {4,3,5,1,2};
        int[] pop3 = new int[] {4,3,5,2,1};

        System.out.println(isPopOrder(push, pop1));
        System.out.println(isPopOrder(push, pop2));
        System.out.println(isPopOrder(push, pop3));
    }

    private static boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null || push.length == 0 || pop.length == 0 || push.length != pop.length) {
            return false;
        }

        boolean isPossable = false;

        Stack<Integer> stack = new Stack<>();

        int pushCur = 0;
        int popCur = 0;
        while (popCur < pop.length) {
            // 添加元素的情况
            // 1.栈中元素已全部弹出，此时直接压栈
            // 2.栈顶元素与当前弹出元素不相等
            while (stack.isEmpty() || stack.peek() != pop[popCur]) {
                // 若是当前序列错误，push已全部入栈，会快速结束循环，直到popCur为length
                if (pushCur == push.length) {
                    break;
                }

                stack.push(push[pushCur]);

                pushCur ++;
            }

            // 若是当前序列错误，push已全部入栈，会快速结束循环，直到popCur为length
            if (stack.peek() != pop[popCur]) {
                break;
            }

            stack.pop();
            popCur ++;
        }

        if (stack.isEmpty() && popCur == pop.length) {
            isPossable = true;
        }

        return isPossable;
    }
}
