package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 构造矩形
 * @date 2020/2/21 13:07
 */
public class Leetcode492 {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        int w = sq(area);

        while (w >= 0) {
            if (area % w == 0) {
                result[0] = area / w;
                result[1] = w;
                break;
            }

            w --;
        }

        return result;
    }

    private int sq(int area) {     // 牛顿法
        long x = area;
        while(x * x > area) {
            x = (x + area / x) / 2;
        }
        return (int) x;
    }
}
