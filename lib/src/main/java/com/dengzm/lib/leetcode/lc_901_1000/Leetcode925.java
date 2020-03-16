package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 长按键入
 * @date 2020/3/15 9:33
 */
public class Leetcode925 {
    public boolean isLongPressedName(String name, String typed) {
        int first = 0, second = 0;
        char pre = '0';

        while (first < name.length() && second < typed.length()) {
            if (name.charAt(first) == typed.charAt(second)) {
                pre = name.charAt(first);
                first ++;
                second ++;
            } else if (typed.charAt(second) == pre) {
                second ++;
            } else {
                return false;
            }
        }

        if (first != name.length()) {
            return false;
        }

        for (; second < typed.length(); second ++) {
            if (typed.charAt(second) != pre) {
                return false;
            }
        }

        return true;
    }
}
