package com.dengzm.lib.leetcode.lc_201_300;

import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 基本计算器 II
 * @date 2020/6/9 14:33
 */
public class Leetcode227 {
    public int calculate(String s) {
        LinkedList<Integer> nums1 = new LinkedList<>();
        LinkedList<Character> symbols1 = new LinkedList<>();

        int num = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                nums1.add(num);
                symbols1.add(c);
                num = 0;
            } else {
                num = num * 10 + c - '0';
            }
        }

        nums1.add(num);

        LinkedList<Integer> nums2 = new LinkedList<>();
        LinkedList<Character> symbols2 = new LinkedList<>();

        num = nums1.pop();
        while (!nums1.isEmpty()) {
            int n = nums1.pop();
            char c = symbols1.pop();

            if (c == '+' || c == '-') {
                nums2.add(num);
                symbols2.add(c);
                num = n;
            } else if (c == '*') {
                num *= n;
            } else if (c == '/') {
                num /= n;
            } else {
                num = num * 10 + c - '0';
            }
        }

        nums2.add(num);

        int ans = nums2.pop();
        while (!nums2.isEmpty()) {
            int n = nums2.pop();
            char c = symbols2.pop();

            if (c == '+') {
                ans += n;
            } else if (c == '-') {
                ans -= n;
            } else if (c == '*') {
                ans *= n;
            } else if (c == '/') {
                ans /= n;
            } else {
                ans = ans * 10 + c - '0';
            }
        }

        return ans;
    }
}
