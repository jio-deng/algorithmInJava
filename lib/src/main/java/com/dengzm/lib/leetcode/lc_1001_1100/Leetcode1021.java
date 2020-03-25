package com.dengzm.lib.leetcode.lc_1001_1100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 删除最外层的括号
 * @date 2020/3/25 8:37
 */
public class Leetcode1021 {
    public String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                if (stack.size() > 1) {
                    res.append(c);
                }
            } else if (c == ')') {
                stack.pop();
                if (stack.size() > 0) {
                    res.append(c);
                }
            }
        }

        return res.toString();
    }
}
