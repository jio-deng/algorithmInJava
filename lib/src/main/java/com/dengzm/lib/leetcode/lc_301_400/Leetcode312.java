package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 戳气球
 * @date 2020/7/19 19:40
 */
class Leetcode312 {
    /**
     * 评论里很多老哥没讲清楚的几个点我这里讲一下：
     *
     * dp[i][j] 表示的是开区间 (i, j) 内戳破所有气球后，能获得的最大***数
     *
     * 相应的存在的与子问题的递推关系，用包含于 (i, j) 的一个索引 k 表示区间内被戳破的最后一个气球，
     * 就能发现 dp[i][j] 的值就是戳破 k 右边的所有气球得到的*** dp[i][k] 加上戳破 k 左边的所有气球得到的*** dp[k][j] ，
     * 再加上戳破索引 k 对应的气球得到的*** nums[i] * nums[k ] * nums[j]（这里注意中间的气球已经都被戳破了）
     *
     * 为什么大部分题解是倒序递推？ 这个现象常常出现在动态规划题里，很多都会用到倒推，特别是用dp[i][j] 表示的某个区间的时候。。。
     * 答案就是：动态规划在求解子问题一定要在父问题之前，假设这里父问题是求解 dp[2][8]，对应的子问题有“求解 dp[5][8]”，
     * 如果这里外层索引循环用顺序，会发现，求解 dp[2][8] 会在求解 dp[5][8] 之前进行。。。显然就不符合动态规划的规则了。
     * 当然也可以顺序，比如外层循环不是数组的一级索引，而是区间长度。。。这样子是可以顺序的。
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] tmp = new int[nums.length + 2];
        System.arraycopy(nums, 0, tmp, 1, nums.length);
        tmp[0] = 1;
        tmp[nums.length+1] = 1;
        nums = tmp;

        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = n-3; i >= 0; i --) {
            for (int j = i+2; j < n; j ++) {
                for (int k = i+1; k < j; k ++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nums[i] * nums[k] * nums[j]);
                }
            }
        }

        return dp[0][n-1];
    }
}
