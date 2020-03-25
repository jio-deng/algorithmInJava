package com.dengzm.lib.leetcode.lc_1001_1100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 不邻接植花
 * @date 2020/3/25 9:08
 */
public class Leetcode1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i ++) {
            map.put(i, new HashSet<>());
        }

        for (int[] p : paths) {
            map.get(p[0] - 1).add(p[1] - 1);
            map.get(p[1] - 1).add(p[0] - 1);
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i ++) {
            boolean[] isUsed = new boolean[5];
            for (int a : map.get(i)) {
                isUsed[ans[a]] = true;
            }

            for (int j = 1; j <= 4; j ++) {
                if (!isUsed[j]) {
                    ans[i] = j;
                    break;
                }
            }
        }

        return ans;
    }
}
