package com.dengzm.lib.leetcode;

import java.util.Stack;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 有效的括号
 * @date 2019/12/30 10:06
 */
public class Leetcode020 {


    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i ++) {
            char c = chars[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char c1 = stack.pop();
                if (c - c1 != 1) {
                    return false;
                }
            } else if (c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char c1 = stack.pop();
                if (c - c1 != 2) {
                    return false;
                }
            }else {
                return false;
            }
        }

        return stack.isEmpty();
    }


    /*------------- 大神解法 ----------------*/
    public boolean isValid1(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack=new Stack<Character>();
        for (char c:s.toCharArray()){
            if (c=='(')
                stack.push(')');
            else if (c=='{')
                stack.push('}');
            else if (c=='[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }

        return stack.isEmpty();
    }

    /*执行结果：通过
      显示详情
      执行用时 :1 ms, 在所有 java 提交中击败了98.94%的用户
      内存消耗 :34.5 MB, 在所有 java 提交中击败了83.78%的用户*/

    public static void main(String[] args) {
        System.out.println(')' - '(');
        System.out.println(']' - '[');
        System.out.println('}' - '{');

        Leetcode020 leetcode020 = new Leetcode020();
        leetcode020.isValid("()[]{}");
    }

}
