package com.dengzm.lib.leetcode.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 08.09. 括号
 * @date 2020/6/19 11:37
 */
public class Ms0809 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesisCore(ans, new StringBuilder(), n, 0, 0);
        return ans;
    }

    private void generateParenthesisCore(List<String> ans, StringBuilder sb, int n, int left, int right) {
        if (left > n) {
            return;
        }

        if (left == n) {
            while (right < left) {
                sb.append(")");
                right ++;
            }

            ans.add(sb.toString());
            return;
        }

        sb.append("(");
        left ++;
        generateParenthesisCore(ans, new StringBuilder(sb), n, left, right);

        while (left < n && right < left) {
            sb.append(")");
            right ++;
            generateParenthesisCore(ans, new StringBuilder(sb), n, left, right);
        }
    }
}
