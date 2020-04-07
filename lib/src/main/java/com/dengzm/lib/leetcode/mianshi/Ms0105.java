package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 01.05. 一次编辑
 * @date 2020/4/6 11:24
 */
public class Ms0105 {
    public boolean oneEditAway(String first, String second) {
        int n = first.length(), m = second.length();
        if (Math.abs(n - m) >= 2) {
            return false;
        }

        if (n == 0 || m == 0 || first.equals(second)) {
            return true;
        }

        int start = 0;
        while (start < n && start < m && first.charAt(start) == second.charAt(start)) {
            start ++;
        }

        int end1 = n-1, end2 = m-1;
        while (end1 >= 0 && end2 >= 0 && first.charAt(end1) == second.charAt(end2)) {
            end1 --;
            end2 --;
        }

        return start >= end1 && start >= end2;
    }
}
