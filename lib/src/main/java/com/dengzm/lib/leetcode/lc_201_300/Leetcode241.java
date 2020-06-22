package com.dengzm.lib.leetcode.lc_201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 为运算表达式设计优先级
 * @date 2020/6/19 11:19
 */
public class Leetcode241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return list;
        }

        for (int i = 0; i < input.length(); i ++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                List<Integer> num1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> num2 = diffWaysToCompute(input.substring(i+1));
                for (int n1 : num1) {
                    for (int n2 : num2) {
                        list.add(doMath(c, n1, n2));
                    }
                }
            }
        }

        if (list.isEmpty()) {
            list.add(Integer.valueOf(input));
        }

        return list;
    }

    private int doMath(char c, int n1, int n2) {
        if (c == '+') {
            return n1 + n2;
        } else if (c == '-') {
            return n1 - n2;
        } else if (c == '*') {
            return n1 * n2;
        } else {
            return n1 / n2;
        }
    }
}
