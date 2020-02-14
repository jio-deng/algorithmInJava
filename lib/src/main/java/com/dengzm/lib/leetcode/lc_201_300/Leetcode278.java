package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 第一个错误的版本
 * @date 2020/2/14 11:53
 */
public class Leetcode278 {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public int firstBadVersion(int n) {
        return firstBadVersionCore(1, n);
    }

    private int firstBadVersionCore(int start, int end) {
        if (start >= end) {
            return start;
        }

        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            return firstBadVersionCore(start, mid);
        } else {
            return firstBadVersionCore(mid + 1, end);
        }
    }

    boolean isBadVersion(int version){
        return false;
    }
}
