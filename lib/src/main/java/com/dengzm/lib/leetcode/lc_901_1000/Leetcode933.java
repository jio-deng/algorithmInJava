package com.dengzm.lib.leetcode.lc_901_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最近的请求次数
 * @date 2020/3/17 8:59
 */
public class Leetcode933 {
    class RecentCounter {
        List<Integer> datas = new ArrayList<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            datas.add(t);
            return datas.size() - findLoc(t - 3000);
        }

        private int findLoc(int t) {
            int start = 0, end = datas.size() - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (datas.get(mid) < t) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            return start;
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
