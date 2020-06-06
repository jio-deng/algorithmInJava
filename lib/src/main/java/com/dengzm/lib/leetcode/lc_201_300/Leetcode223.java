package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 矩形面积
 * @date 2020/6/6 10:03
 */
public class Leetcode223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B), area2 = (G - E) * (H - F);
        if (C <= E || A >= G || B >= H || D <= F) {
            return area1 + area2;
        }

        int topX = Math.min(G, C), topY = Math.min(H, D), botX = Math.max(E, A), botY = Math.max(F, B);
        return area1 - (topY - botY) * (topX - botX) + area2;
    }
}
