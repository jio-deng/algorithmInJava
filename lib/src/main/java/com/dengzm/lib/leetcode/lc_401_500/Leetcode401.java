package com.dengzm.lib.leetcode.lc_401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二进制手表
 * @date 2020/2/15 19:02
 */
public class Leetcode401 {
    public List<String> readBinaryWatch(int num) {
        int[] watch = new int[] {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        boolean[] isOn = new boolean[10];

        List<String> result = new ArrayList<>();
        readBinaryWatchCore(result, watch, isOn, num, 0, 0);

        return result;
    }

    private void readBinaryWatchCore(List<String> list, int[] watch, boolean[] isOn, int num, int current, int start) {
        if (num == current) {
            int hour = 0, minute = 0;
            for (int i = 0; i < watch.length; i ++) {
                if (isOn[i]) {
                    if (i < 4) {
                        hour += watch[i];
                    } else {
                        minute += watch[i];
                    }
                }
            }
            if (hour >= 12 || minute >= 60) return;

            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":");
            if (minute < 10) {
                sb.append("0");
            }
            sb.append(minute);
            list.add(sb.toString());
            return;
        }

        for (int i = start; i < watch.length; i ++) {
            isOn[i] = true;
            readBinaryWatchCore(list, watch, isOn, num, current + 1, i + 1);
            isOn[i] = false;
        }
    }
}
