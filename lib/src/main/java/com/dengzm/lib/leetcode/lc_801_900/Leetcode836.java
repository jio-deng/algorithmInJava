package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 矩形重叠
 * @date 2020/3/10 10:17
 */
public class Leetcode836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 判断四种不相交的情况即可
        return rec1[0] < rec2[2]
                && rec2[0] < rec1[2]
                && rec1[1] < rec2[3]
                && rec2[1] < rec1[3];
    }
}
