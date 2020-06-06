package com.dengzm.lib.leetcode.lc_301_400;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 字符串解码
 * @date 2020/5/28 21:17
 */
public class Leetcode394 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int start = 0;
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Integer> starts = new ArrayDeque<>();
        int flag = 0;

        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '[') {
                flag ++;
                if (flag == 1) {
                    nums.push(Integer.valueOf(s.substring(start, i)));
                    starts.push(i + 1);
                }
            } else if (s.charAt(i) == ']') {
                flag --;
                if (flag == 0) {
                    start = i + 1;
                    String s1 = decodeString(s.substring(starts.pop(), i));
                    int num = nums.pop();
                    while (num > 0) {
                        sb.append(s1);
                        num --;
                    }
                }
            } else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                if (nums.isEmpty()) {
                    sb.append(s.charAt(i));
                }
                start = i + 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode394 leetcode394 = new Leetcode394();
        leetcode394.decodeString("3[a2[c]]");
    }
}
