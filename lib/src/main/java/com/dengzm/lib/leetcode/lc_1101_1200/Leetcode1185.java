package com.dengzm.lib.leetcode.lc_1101_1200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 一周中的第几天
 * @date 2020/3/31 16:31
 */
public class Leetcode1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        int count = 4;
        for (int i = 1970; i < year; i ++) {
            if (i % 100 != 0 && i % 4 == 0 || i % 400 == 0) {
                count += 366;
            } else {
                count += 365;
            }
        }

        int[] days = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
        if (year % 100 != 0 && year % 4 == 0 || year % 400 == 0) {
            days[1] = 29;
        }

        for (int i = 0; i < month - 1; i ++) {
            count += days[i];
        }

        count += day - 1;
        return week[count % 7];
    }
}
