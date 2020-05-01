package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 爱吃香蕉的珂珂
 * @date 2020/4/30 17:07
 */
public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int H) {
        int start = 1, end = 0;
        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            int time = 0;
            for (int pile : piles) {
                time += pile / mid;
                if (pile % mid != 0) {
                    time ++;
                }
            }

            if (time > H) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
