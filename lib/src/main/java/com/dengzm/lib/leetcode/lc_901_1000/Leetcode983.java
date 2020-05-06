package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最低票价
 * @date 2020/5/6 9:44
 */
public class Leetcode983 {

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        int maxDay = days[days.length - 1];
        int curIndex = 0;
        for (int i = 1; i <= maxDay; i ++) {
            if (i != days[curIndex]) {
                dp[i] = dp[i-1];
            } else {
                curIndex ++;
                int v1 = dp[Math.max(0, i - 1)] + costs[0];
                int v2 = dp[Math.max(0, i - 7)] + costs[1];
                int v3 = dp[Math.max(0, i - 30)] + costs[2];

                dp[i] = Math.min(Math.min(v1, v2), v3);
            }
        }

        return dp[maxDay];
    }


//    int ans = Integer.MAX_VALUE;
//    public int mincostTickets(int[] days, int[] costs) {
//        mincostTicketsCore(days, costs, 0, 0, 0);
//        return ans;
//    }
//
//    private void mincostTicketsCore(int[] days, int[] costs, int cur, int end, int sum) {
//        if (end > days[days.length - 1] || cur >= days.length) {
//            ans = Math.min(ans, sum);
//            return;
//        }
//
//        // System.out.println(sum);
//
//        if (days[cur] < end) {
//            mincostTicketsCore(days, costs, cur + 1, end, sum);
//        } else {
//            mincostTicketsCore(days, costs, cur + 1, days[cur] + 1, sum + costs[0]);
//            mincostTicketsCore(days, costs, cur + 1, days[cur] + 7, sum + costs[1]);
//            mincostTicketsCore(days, costs, cur + 1, days[cur] + 30, sum + costs[2]);
//        }
//    }


    public static void main(String[] args) {
        Leetcode983 leetcode983 = new Leetcode983();
        int[] i1 = new int[] {1,4,6,7,8,20};
        int[] i2 = new int[] {2,7,15};
        leetcode983.mincostTickets(i1, i2);
    }
}
