package com.dengzm.lib.leetcode.lc_1_100;

import java.util.Stack;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 简化路径
 * @date 2020/1/28 18:53
 */
public class Leetcode071 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }

        Stack<String> stack = new Stack<>();
        char[] chars = path.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] == '/') {
                if (sb.length() != 0) {
                    if (sb.toString().equals("..")) {
                        if (!stack.empty()) {
                            stack.pop();
                        }
                    } else if (sb.toString().equals(".")) {
                        // do nothing
                    }else {
                        stack.push(sb.toString());
                    }

                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(chars[i]);
            }
        }

        if (sb.length() != 0) {
            if (sb.toString().equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (sb.toString().equals(".")) {
                // do nothing
            }else {
                stack.push(sb.toString());
            }

            sb.delete(0, sb.length());
        }

        if (stack.isEmpty()) {
            return "/";
        }

        sb.delete(0, sb.length());
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }

        return sb.toString();
    }
}
