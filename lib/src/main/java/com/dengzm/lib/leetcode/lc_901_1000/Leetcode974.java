package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 和可被 K 整除的子数组
 * @date 2020/5/27 12:01
 */
public class Leetcode974 {
    public int subarraysDivByK(int[] A, int K) {
        int[] dp = new int[K];  // 要么除K = 0, 只有当两个都是在里面的时候才进行加入
        int count = 0;
        int t = 0;
        int ans = 0;
        int i;
        for (i = 0; i < A.length; i++) {
            count += A[i];
            if (count % K < 0) {
                t = count % K + K;
            } else {
                t = count % K;
            }
            if (t == 0) {
                dp[0] += 1;
                ans += dp[0];
            } else if (dp[t] == 0) {
                dp[t] = 1;
            } else{
                ans += dp[t];
                dp[t] += 1;
            }
        }
        return ans;
    }

//    public int subarraysDivByK(int[] A, int K) {
//        int n = A.length;
//        if (n == 0 || K == 0) {
//            return 0;
//        }
//
//        int ans = 0;
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i ++) {
//            for (int j = i; j < n; j ++) {
//                if (i == 0) {
//                    if (j == i) {
//                        dp[j] = A[j];
//                    } else {
//                        dp[j] = A[j] + dp[j-1];
//                    }
//                } else {
//                    dp[j] = dp[j] - A[i-1];
//                }
//
//                if (dp[j] % K == 0) {
//                    ans ++;
//                }
//            }
//        }
//
//        return ans;
//    }
}
