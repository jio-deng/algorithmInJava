package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 矩阵中的最长递增路径
 * @date 2020/7/26 11:28
 */
class Leetcode329 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];

        int res = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                res = Math.max(res, get(dp, n, m, i, j, matrix));
            }
        }

        return res;
    }

    private int get(int[][] dp, int n, int m, int i, int j, int[][] matrix) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        int ans = 0, di, dj;
        for (int a = 0; a < 4; a ++) {
            di = i + dy[a];
            dj = j + dx[a];
            if (di < 0 || dj < 0 || di >= n || dj >= m || matrix[di][dj] <= matrix[i][j]) {
                continue;
            }

            ans = Math.max(ans, get(dp, n, m, di, dj, matrix));
        }

        dp[i][j] = ans + 1;
        return dp[i][j];
    }
}
