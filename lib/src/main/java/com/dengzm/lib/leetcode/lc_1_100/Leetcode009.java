package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 回文数
 * @date 2019/12/14 9:20
 */
public class Leetcode009 {
    public boolean isPalindrome(int x) {
        if (x >= 0) {
            if (x < 10) {
                return true;
            }
            int cur = 0;
            int temp = x % 10;
            if (temp == 0) {
                return false;
            }
            while (x > 0) {
                temp = x % 10;
                cur = cur * 10 + temp;
                x = x / 10;
                if (x == cur || (x / 10 != 0 && x / 10 == cur)) {
                    return true;
                }
            }
        }

        return false;
    }

    /*执行结果：通过
      显示详情
      执行用时 :9 ms, 在所有 java 提交中击败了98.66%的用户
      内存消耗 :36.2 MB, 在所有 java 提交中击败了96.96%的用户*/
}
