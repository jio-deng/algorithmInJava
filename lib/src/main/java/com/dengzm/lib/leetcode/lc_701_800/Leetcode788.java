package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 旋转数字
 * @date 2020/3/7 9:41
 */
public class Leetcode788 {
    public int rotatedDigits(int N) {
        int ans = 0;
        int tmp;
        int sin;
        for (int i = 2; i <= N; i ++) {
            boolean isRotateDigit = false;
            tmp = i;
            while (tmp > 0) {
                sin = tmp % 10;
                if (sin == 2 || sin == 5 || sin == 6 || sin == 9) {
                    isRotateDigit = true;
                } else if (sin == 0 || sin == 1 || sin == 8) {
                    // do nothing
                } else {
                    isRotateDigit = false;
                    break;
                }

                tmp /= 10;
            }

            if (isRotateDigit) {
                ans ++;
            }
        }

        return ans;
    }
}
