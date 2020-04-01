package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description LCP 2. 分式化简
 * @date 2020/4/1 14:04
 */
public class LCP2 {
    public int[] fraction(int[] cont) {
        int[] ans = new int[2];
        int up = 1, down = 0;
        for (int i = cont.length - 1; i >= 0; i --) {
            up = up + down - (down = up);
            up += down * cont[i];
        }

        ans[0] = up;
        ans[1] = down;
        return ans;
    }
}
