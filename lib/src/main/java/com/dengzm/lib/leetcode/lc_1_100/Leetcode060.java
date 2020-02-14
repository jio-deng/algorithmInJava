package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 第k个排列
 * @date 2020/1/25 10:56
 */
public class Leetcode060 {

    /**
     * https://leetcode-cn.com/problems/permutation-sequence/solution/zhi-xing-yong-shi-1-ms-zai-suo-you-java-ti-jiao-54/
     */

    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        // 将 n! 种排列分为：n 组，每组有 (n - 1)! 种排列
        return recursive(n, factorial(n - 1), k, visited);
    }

    private String recursive(int n, int f, int k, boolean[] visited) {
        int offset = k % f;
        int groupIndex = k / f + (offset > 0 ? 1 : 0);

        int i = 0;
        for (; i < visited.length && groupIndex > 0; i ++) {
            if (!visited[i]) {
                groupIndex --;
            }
        }

        visited[i - 1] = true;

        if(n - 1 > 0){
            // offset = 0 时，则取第 i 组的第 f 个排列，否则取第 i 组的第 offset 个排列
            return String.valueOf(i) + recursive(n - 1, f / (n - 1), offset == 0 ? f : offset, visited);
        }else{
            // 最后一数字
            return String.valueOf(i);
        }
    }

    /**
     * 求 n!
     */
    private int factorial(int n){
        int res = 1;
        for(int i = n; i > 1; i--){
            res *= i;
        }
        return res;
    }
}
