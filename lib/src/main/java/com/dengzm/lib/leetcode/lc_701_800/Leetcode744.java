package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 寻找比目标字母大的最小字母
 * @date 2020/3/5 12:34
 */
public class Leetcode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        char min = 'z' + 1;
        char minAll = 'z' + 1;
        boolean isFound = false;
        for (char c : letters) {
            if (c > target && c < min) {
                isFound = true;
                min = c;
            }

            if (c < minAll) {
                minAll = c;
            }
        }

        return isFound ? min : minAll;
    }
}
