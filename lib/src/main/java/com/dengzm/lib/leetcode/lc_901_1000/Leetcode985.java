package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 查询后的偶数和
 * @date 2020/3/20 11:36
 */
public class Leetcode985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int sum = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                sum += a;
            }
        }

        for (int i = 0; i < queries.length; i ++) {
            int[] query = queries[i];
            int index = query[1];
            int val = query[0];
            if (A[index] % 2 == 0) {
                sum -= A[index];
            }

            A[index] += val;
            if (A[index] % 2 == 0) {
                sum += A[index];
            }

            ans[i] = sum;
        }

        return ans;
    }
}
