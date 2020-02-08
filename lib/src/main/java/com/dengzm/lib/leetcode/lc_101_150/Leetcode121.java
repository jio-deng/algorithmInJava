package com.dengzm.lib.leetcode.lc_101_150;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 买卖股票的最佳时机
 * @date 2020/2/7 18:59
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        int maxSell = 0;

        for (int i = prices.length - 1; i >= 0; i --) {
            if (prices[i] >= maxSell) {
                maxSell = prices[i];
                continue;
            }

            int profit = maxSell - prices[i];
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
