package com.dengzm.lib.leetcode.lc_1001_1100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 删除字符串中的所有相邻重复项
 * @date 2020/3/25 9:00
 */
public class Leetcode1047 {
    public String removeDuplicates(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        StringBuilder res = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char pre = stack.peek();
                if (pre == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pollLast());
        }

        return res.toString();
    }
}
