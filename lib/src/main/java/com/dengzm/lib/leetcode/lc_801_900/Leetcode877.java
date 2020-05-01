package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 石子游戏
 * @date 2020/5/1 13:51
 */
public class Leetcode877 {
    /**
     * 因为是偶数个堆，所以两个人最后拿到的堆数是一样的，
     * 但是因为石头的数量是奇数，所以最后两人拿到的石头数量肯定不能相等，肯定一个多一个少，且和为奇数，
     * 所以先手的人只要选择多的那种方式拿就行了，
     * 所以先手必赢
     */
//    public boolean stoneGame(int[] piles) {
//        return true;
//    }


    public boolean stoneGame(int[] piles) {
        int N = piles.length;

        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]].
        int[][] dp = new int[N+2][N+2];
        for (int size = 1; size <= N; ++size)
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                int parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
                if (parity == 1)
                    dp[i+1][j+1] = Math.max(piles[i] + dp[i+2][j+1], piles[j] + dp[i+1][j]);
                else
                    dp[i+1][j+1] = Math.min(-piles[i] + dp[i+2][j+1], -piles[j] + dp[i+1][j]);
            }

        return dp[1][N] > 0;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/stone-game/solution/shi-zi-you-xi-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
