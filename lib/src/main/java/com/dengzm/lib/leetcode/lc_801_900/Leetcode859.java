package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 亲密字符串
 * @date 2020/3/11 10:43
 */
public class Leetcode859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        char c1 = '.', c2 = '.';
        int index = -1;

        int[] chars = new int[128];

        for (int i = 0; i < A.length(); i ++) {
            chars[A.charAt(i)] ++;

            if (A.charAt(i) != B.charAt(i)) {
                if (index == -1) {
                    c1 = A.charAt(i);
                    c2 = B.charAt(i);
                    index = 0;
                } else {
                    if (index >= 1 || c1 != B.charAt(i) || c2 != A.charAt(i)) {
                        return false;
                    }

                    index ++;
                }
            }
        }

        if (index == -1) {
            for (int num : chars) {
                if (num >= 2) {
                    return true;
                }
            }

            return false;
        }

        return true;
    }
}
