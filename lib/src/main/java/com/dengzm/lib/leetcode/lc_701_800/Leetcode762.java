package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二进制表示中质数个计算置位
 * @date 2020/3/7 8:55
 */
public class Leetcode762 {
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        boolean[] prims = getNonPrims();
        for (int i = L; i <= R; i ++) {
            if (i <= 0) {
                continue;
            }

            int tmp = i, nums = 0;
            while (tmp > 0) {
                nums += tmp & 1;
                tmp >>= 1;
            }

            if (nums > 0 && !prims[nums-1]) {
                ans ++;
            }
        }

        return ans;
    }

    private boolean[] getNonPrims() {
        boolean[] result = new boolean[32];
        result[0] = true;

        for (int i = 1; i < 32; i ++) {
            if (!result[i]) {
                int tmp = (i+1) * 2;
                while (tmp <= 32) {
                    result[tmp-1] = true;
                    tmp += (i+1);
                }
            }
        }

        return result;
    }
}
