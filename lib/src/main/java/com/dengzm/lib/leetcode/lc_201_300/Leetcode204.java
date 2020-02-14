package com.dengzm.lib.leetcode.lc_201_300;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 计数质数
 * @date 2020/2/13 13:18
 */
public class Leetcode204 {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }
}
