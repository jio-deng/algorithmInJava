package com.dengzm.lib.leetcode.lc_301_400;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 零钱兑换
 * @date 2020/3/8 7:55
 */
public class Leetcode322 {
    private static final int INF = 100000;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= amount; i ++) {
            int index = 0;
            while (index < coins.length) {
                int index2 = i - coins[index];
                if (index2 < 0) {
                    break;
                }

                dp[i] = Math.min(dp[i], dp[index2] + 1);

                index ++;
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }


    /**
     * 回溯 超时了
     */
//    private int min = 100000;
//
//    public int coinChange(int[] coins, int amount) {
//        if (coins == null || coins.length == 0 || amount < 0) {
//            return -1;
//        }
//
//        Arrays.sort(coins);
//
//        coinChangeCore(coins, amount, 0, coins.length - 1, 0);
//
//        return min == 100000 ? -1 : min;
//    }
//
//    private void coinChangeCore(int[] coins, int amount, int sum, int index, int min) {
//        if (amount == sum) {
//            this.min = Math.min(min, this.min);
//            return;
//        }
//
//        if (index < 0) {
//            return;
//        }
//
//        int coin = coins[index];
//        int numsOfCoin = (amount - sum) / coin;
//        for (int i = numsOfCoin; i >= 0; i --) {
//            coinChangeCore(coins, amount, sum + i * coin, index - 1, min + i);
//        }
//
//        return;
//    }

    public static void main(String[] args) {
        Leetcode322 leetcode322 = new Leetcode322();
        int[] coins = new int[] {470,18,66,301,403,112,360};
        int amount = 8235;
        System.out.println(leetcode322.coinChange(coins, amount));
    }
}
