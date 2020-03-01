package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 重复叠加字符串匹配
 * @date 2020/2/29 11:57
 */
public class Leetcode686 {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder tmpA = new StringBuilder(A);
        int cnt = 1, aSize = A.length(), bSize = B.length(), midRepeat = bSize / aSize;
        while (cnt <= midRepeat + 2) {
            if (tmpA.toString().contains(B)) {
                return cnt;
            }

            tmpA.append(A);
            cnt ++;
        }

        return -1;
    }

}
