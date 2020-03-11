package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 比较含退格的字符串
 * @date 2020/3/11 10:06
 */
public class Leetcode844 {
    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }

    private String getString(String target) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : target.toCharArray()) {
            if (c != '#') {
                stringBuilder.append(c);
            } else {
                if (stringBuilder.length() != 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }

        return stringBuilder.toString();
    }
}
