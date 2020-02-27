package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 买卖股票的最佳时机 III
 * @date 2020/2/24 17:17
 */
public class Leetcode123 {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0, secBuy = Integer.MIN_VALUE, secSell = 0;
        for (int p : prices) {
            firstBuy = Math.max(firstBuy, -p);
            firstSell = Math.max(firstSell, firstBuy + p);
            secBuy = Math.max(secBuy, firstSell - p);
            secSell = Math.max(secSell, secBuy + p);
        }

        return secSell;
    }
}
