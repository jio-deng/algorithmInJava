package com.dengzm.lib.leetcode.lc_301_400;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 309. 最佳买卖股票时机含冷冻期
 * @date 2020/4/13 10:47
 */
public class Leetcode309 {
    private Map<Integer, Integer> map0 = new HashMap<>();
    private Map<Integer, Integer> map1 = new HashMap<>();
    private Map<Integer, Integer> map2 = new HashMap<>();

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i ++) {
            max = Math.max(max, maxProfitCore(prices, i, 0, 0));
        }

        return max;
    }

    private int maxProfitCore(int[] prices, int cur, int status, int val) {
        if (cur >= prices.length) {
            return val;
        }

        int ans = 0;

        if (status == 0) {
            if (map0.containsKey(cur)) {
                ans = map0.get(cur);
            } else {
                ans = Math.max(maxProfitCore(prices, cur + 1, 1, -prices[cur]),
                        maxProfitCore(prices, cur + 1, 0, 0));
                map0.put(cur, ans);
            }
        } else if (status == 1) {
            if (map1.containsKey(cur)) {
                ans = map1.get(cur);
            } else {
                ans = Math.max(maxProfitCore(prices, cur + 1, 2, prices[cur]),
                        maxProfitCore(prices, cur + 1, 1, 0));
                map1.put(cur, ans);
            }
        } else if (status == 2) {
            if (map2.containsKey(cur)) {
                ans = map2.get(cur);
            } else {
                ans = maxProfitCore(prices, cur + 1, 0, 0);
                map2.put(cur, ans);
            }
        }

        ans += val;
        return ans;
    }
}
