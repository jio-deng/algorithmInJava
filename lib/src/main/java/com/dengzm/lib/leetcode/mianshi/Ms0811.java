package com.dengzm.lib.leetcode.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 08.11. 硬币
 * @date 2020/4/23 18:39
 */
public class Ms0811 {
    private int MOD = (int) 1e9 + 7;
    private int[] coins = new int[] {25, 10, 5, 1};

    // dp[i][j] 使用前i种硬币计算j分的表示法种数 令coins=[25, 10, 5, 1]
    // dp[i][j] = dp[i-1][j] + dp[i-1][j-coins[i]] + dp[i-1][j-2*coins[i]] + ... dp[i-1][j-k*coins[i]]
    // j >= k*coins[i]
    // dp[i][j-coins[i]] = dp[i-1][j-coins[i]] + dp[i-1][j-2*coins[i]] + ... dp[i-1][j-k*coins[i]]
    // dp[i][j] - dp[i][j-coins[i]] = dp[i-1][j]
    // dp[i][j] = dp[i][j-coins[i]] + dp[i-1][j]
    public int waysToChange(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i ++) {
            for (int j = coins[i]; j < n+1; j ++) {
                dp[j] += dp[j - coins[i]];
                dp[j] %= MOD;
            }
        }

        return dp[n];
    }



    /**
     * timeout
     */
//    private Map[] maps = new Map[3];
//
//    public int waysToChange(int n) {
//        if (n <= 0) {
//            return 0;
//        }
//
//        maps[0] = new HashMap<Integer, Integer>();
//        maps[1] = new HashMap<Integer, Integer>();
//        maps[2] = new HashMap<Integer, Integer>();
//
//        return waysToChangeCore(n, 0);
//    }
//
//    private int waysToChangeCore(int n, int cur) {
//        if (cur >= 4) {
//            return 0;
//        }
//
//        if (cur == 3) {
//            return 1;
//        }
//
//        if (maps[cur].containsKey(n)) {
//            return (int) maps[cur].get(n);
//        }
//
//        int ans = 0;
//        int size = n / coins[cur];
//        for (int i = 0; i <= size; i ++) {
//            ans += waysToChangeCore(n - coins[cur] * i, cur + 1);
//        }
//
//        maps[cur].put(n, ans);
//
//        return ans % MOD;
//    }
}
