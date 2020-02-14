package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 买卖股票的最佳时机 II
 * @date 2020/2/7 19:27
 */
public class Leetcode122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;
        int maxSell = 0;
        int minBuy = 0;

        for (int i = prices.length - 1; i >= 0; i --) {
            if (prices[i] >= maxSell) {
                profit += maxSell - minBuy;
                maxSell = prices[i];
                minBuy = prices[i];
            } else if (prices[i] >= minBuy) {
                profit += maxSell - minBuy;
                maxSell = prices[i];
                minBuy = prices[i];
            } else {
                minBuy = prices[i];
            }
        }

        profit += maxSell - minBuy;

        return profit;
    }
}
