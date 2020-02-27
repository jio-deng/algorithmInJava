package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 种花问题
 * @date 2020/2/25 9:17
 */
public class Leetcode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        for (int i = 0; i < flowerbed.length; i ++) {
            boolean flag = false;
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    if (i+1 >= flowerbed.length || flowerbed[i+1] == 0) {
                        flag = true;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i-1] == 0) {
                        flag = true;
                    }
                } else {
                    if (flowerbed[i+1] == 0 && flowerbed[i-1] == 0) {
                        flag = true;
                    }
                }
            }

            if (flag) {
                flowerbed[i] = 1;
                ans ++;
            }

            if (ans >= n) {
                break;
            }
        }

        return ans >= n;
    }
}
