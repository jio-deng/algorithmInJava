package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 837. 新21点
 * @date 2020/6/3 9:25
 */
public class Leetcode837 {
    public double new21Game(int N, int K, int W) {
        double[]dp=new double[N+1];
        double sum=0;
        dp[0]=1;
        if(K>0) sum+=1;
        for(int i=1;i<=N;i++){
            dp[i]=sum/W;
            if(i<K) sum+=dp[i];
            if(i>=W) sum-=dp[i-W];
        }
        double ans=0;
        for(int i=K;i<=N;i++) ans+=dp[i];
        return ans;
    }
//    public double new21Game(int N, int K, int W) {
//        if (N == K) {
//            return 1;
//        }
//
//        double[] dp = new double[K + 1];
//        dp[0] = 1;
//
//        for (int i = 1; i <= K; i ++) {
//            for (int j = i - W; j < i; j ++) {
//                if (j < 0) {
//                    continue;
//                }
//
//                dp[i] += dp[j] / Math.min(W, K - j);
//            }
//
//            if (i <= W) {
//                dp[i] += 1 / W;
//            }
//        }
//
//        return dp[K];
//    }
}
