package com.dengzm.lib.leetcode.lc_1001_1100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 山脉数组中查找目标值
 * @date 2020/4/29 17:42
 */
public class Leetcode1095 {
    private MountainArray mountainArr;
    private int[] memo;
    public int findInMountainArray(int target, MountainArray mountainArr) {
        this.mountainArr = mountainArr;
        int size = mountainArr.length();
        memo = new int[size];

        int start = 0, end = size - 1;

        if (mountainArr.get(start) > target && mountainArr.get(end) > target) {
            return -1;
        }

        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            int val = get(mid);
            int left = mid - 1 >= 0 ? get(mid - 1) : val - 1;
            int right = mid + 1 < size ? get(mid + 1) : val - 1;
            if (val > left && val > right) {
                break;
            } else if (left < val && val < right) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (get(mid) == target) {
            return mid;
        }

        start = 0;
        end = mid;

        while (start <= end) {
            int m = start + (end - start) / 2;
            int val = get(m);
            if (val == target) {
                return m;
            } else if (val > target) {
                end = m - 1;
            } else {
                start = m + 1;
            }
        }

        start = mid;
        end = size - 1;

        while (start <= end) {
            int m = start + (end - start) / 2;
            int val = get(m);
            if (val == target) {
                return m;
            } else if (val > target) {
                start = m + 1;
            } else {
                end = m - 1;
            }
        }

        return -1;
    }

    public int get(int index) {
        if (memo[index] == 0) {
            memo[index] = mountainArr.get(index);
        }

        return memo[index];
    }

    interface MountainArray {
       int get(int index);
       int length();
    }
}
