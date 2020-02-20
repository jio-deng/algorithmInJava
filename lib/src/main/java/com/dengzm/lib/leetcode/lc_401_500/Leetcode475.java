package com.dengzm.lib.leetcode.lc_401_500;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 供暖器
 * @date 2020/2/20 19:58
 */
public class Leetcode475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int[] minDistances = new int[houses.length];
        for (int i = 0; i < houses.length; i ++) {
            int house = houses[i];

            int left = 0, right = heaters.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (heaters[mid] == house) {
                    left = mid;
                    break;
                } else if (heaters[mid] < house) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            int heat = heaters[left];
            if (heat == house) {
                minDistances[i] = 0;
            } else if (heat < house) {
                minDistances[i] = house - heat;
            } else if (left != 0) {
                minDistances[i] = Math.min(heaters[left] - house, house - heaters[left - 1]);
            } else {
                minDistances[i] = Math.abs(heaters[left] - house);
            }
        }

        int ans = minDistances[0];
        for (int i : minDistances) {
            ans = Math.max(ans, i);
        }

        return ans;
    }
}
