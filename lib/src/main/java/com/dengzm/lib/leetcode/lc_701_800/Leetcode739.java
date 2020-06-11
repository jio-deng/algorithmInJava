package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 每日温度
 * @date 2020/6/11 9:41
 */
public class Leetcode739 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        } else if (T.length == 1) {
            return new int[1];
        }

        int[] ans = new int[T.length];
        for (int i = T.length - 2; i >= 0; i --) {
            int nxt = i + 1;
            while (true) {
                if (T[nxt] > T[i]) {
                    ans[i] = nxt - i;
                    break;
                } else {
                    if (ans[nxt] == 0) {
                        break;
                    } else {
                        nxt = nxt + ans[nxt];
                    }
                }
            }
        }

        return ans;
    }
}
