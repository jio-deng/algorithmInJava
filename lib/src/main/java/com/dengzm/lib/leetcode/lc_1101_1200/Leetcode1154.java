package com.dengzm.lib.leetcode.lc_1101_1200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 一年中的第几天
 * @date 2020/3/27 10:44
 */
public class Leetcode1154 {
    public int dayOfYear(String date) {
        int ans = 0;
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int year = Integer.valueOf(date.substring(0, 4));
        if (year % 100 != 0 && year % 4 == 0 || year % 400 == 0) {
            days[1] = 29;
        }

        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8));

        for (int i = 1; i < month; i ++) {
            ans += days[i-1];
        }

        ans += day;
        return ans;
    }
}
