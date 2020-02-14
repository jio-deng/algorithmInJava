package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最小覆盖子串
 * @date 2020/2/2 9:35
 */
public class Leetcode076 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] needs = new int[128];
        for (char c : t.toCharArray()) {
            needs[c] ++;
        }

        int[] window = new int[128];

        // 滑动窗口的有效字符长度
        int currentLen = 0;
        int minLen = s.length() + 1;
        String result = "";
        int l = 0, r = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            window[c] ++;
            if (window[c] <= needs[c]) {
                currentLen ++;

                if (currentLen == t.length()) {
                    while (l < r) {
                        char cl = s.charAt(l);
                        if (window[cl] <= needs[cl]) {
                            break;
                        }

                        window[cl] --;
                        l ++;
                    }

                    System.out.println("l=" + l + ",r=" + r);
                    int len = r - l + 1;
                    if (len < minLen) {
                        result = s.substring(l, r + 1);
                        minLen = len;
                    }

                    char cl = s.charAt(l);
                    window[cl] --;
                    currentLen --;
                    l ++;
                }
            }

            r ++;
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode076 leetcode076 = new Leetcode076();
        leetcode076.minWindow("ADOBECODEBANC", "ABC");
    }
}
