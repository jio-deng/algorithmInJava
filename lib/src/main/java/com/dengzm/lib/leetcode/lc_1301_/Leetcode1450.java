package com.dengzm.lib.leetcode.lc_1301_;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 在既定时间做作业的学生人数
 * @date 2020/6/16 11:35
 */
public class Leetcode1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i ++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                ans ++;
            }
        }

        return ans;
    }
}
