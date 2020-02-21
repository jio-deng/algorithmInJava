package com.dengzm.lib.leetcode.lc_401_500;

import java.util.HashMap;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 回旋镖的数量
 * @date 2020/2/21 17:30
 */
public class Leetcode447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i ++) {
            for (int j = 0; j < points.length; j ++) {
                if (i == j) {
                    continue;
                }

                double dis = Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2);
                if (!map.containsKey(dis)) {
                    map.put(dis, 1);
                } else {
                    int times = map.get(dis);
                    ans += 2 * times;
                    map.put(dis, times + 1);
                }
            }

            map.clear();
        }

        return ans;
    }
}
