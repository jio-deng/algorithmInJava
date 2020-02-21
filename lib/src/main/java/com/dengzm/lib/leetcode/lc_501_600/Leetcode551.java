package com.dengzm.lib.leetcode.lc_501_600;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 学生出勤记录 I
 * @date 2020/2/21 16:14
 */
public class Leetcode551 {
    public boolean checkRecord(String s) {
        int numOfAbsent = 0;
        int numOfLate = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                numOfAbsent ++;
                if (numOfAbsent > 1) {
                    return false;
                }
            } else if (c == 'L') {
                numOfLate ++;
                if (numOfLate > 2) {
                    return false;
                }
                continue;
            }
            numOfLate = 0;
        }

        return true;
    }
}
