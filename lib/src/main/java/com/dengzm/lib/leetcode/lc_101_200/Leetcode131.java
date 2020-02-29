package com.dengzm.lib.leetcode.lc_101_200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 分割回文串
 * @date 2020/2/28 11:45
 */
public class Leetcode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        int[][] dp = new int[s.length()][s.length()];
        for (int right = 0; right < s.length(); right ++) {
            for (int left = 0; left <= right; left ++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left+1][right-1] == 1)) {
                    dp[left][right] = 1;
                }
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        backTracing(s, 0, s.length(), dp, stack, res);
        return res;
    }

    private void backTracing(String s, int start, int len, int[][] dp, Deque<String> stack, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < len; i ++) {
            if (dp[start][i] == 0) {
                continue;
            }

            stack.addLast(s.substring(start, i + 1));
            backTracing(s, i+1, len, dp, stack, res);
            stack.removeLast();
        }
    }
}
