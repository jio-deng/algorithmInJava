package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/1/26 9:58
 */
public class LeetcodeComp200126 {
    /**
     * 5319. 删除回文子序列
     * 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
     *
     * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
     *
     * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
     *
     * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "ababa"
     * 输出：1
     * 解释：字符串本身就是回文序列，只需要删除一次。
     * 示例 2：
     *
     * 输入：s = "abb"
     * 输出：2
     * 解释："abb" -> "bb" -> "".
     * 先删除回文子序列 "a"，然后再删除 "bb"。
     * 示例 3：
     *
     * 输入：s = "baabb"
     * 输出：2
     * 解释："baabb" -> "b" -> "".
     * 先删除回文子序列 "baab"，然后再删除 "b"。
     * 示例 4：
     *
     * 输入：s = ""
     * 输出：0
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 1000
     * s 仅包含字母 'a'  和 'b'
     */
    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length() / 2; i ++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return 2;
            }
        }

        return 1;
    }


    /**
     * 5320. 餐厅过滤器
     * 给你一个餐馆信息数组 restaurants，其中  restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]。你必须使用以下三个过滤器来过滤这些餐馆信息。
     *
     * 其中素食者友好过滤器 veganFriendly 的值可以为 true 或者 false，如果为 true 就意味着你应该只包括 veganFriendlyi 为 true 的餐馆，为 false 则意味着可以包括任何餐馆。此外，我们还有最大价格 maxPrice 和最大距离 maxDistance 两个过滤器，它们分别考虑餐厅的价格因素和距离因素的最大值。
     *
     * 过滤后返回餐馆的 id，按照 rating 从高到低排序。简单起见， veganFriendlyi 和 veganFriendly 为 true 时取值为 1，为 false 时，取值为 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 1, maxPrice = 50, maxDistance = 10
     * 输出：[3,1,5]
     * 解释：
     * 这些餐馆为：
     * 餐馆 1 [id=1, rating=4, veganFriendly=1, price=40, distance=10]
     * 餐馆 2 [id=2, rating=8, veganFriendly=0, price=50, distance=5]
     * 餐馆 3 [id=3, rating=8, veganFriendly=1, price=30, distance=4]
     * 餐馆 4 [id=4, rating=10, veganFriendly=0, price=10, distance=3]
     * 餐馆 5 [id=5, rating=1, veganFriendly=1, price=15, distance=1]
     * 在按照 veganFriendly = 1, maxPrice = 50 和 maxDistance = 10 进行过滤后，我们得到了餐馆 3, 餐馆 1 和 餐馆 5（按评分从高到低排序）。
     * 示例 2：
     *
     * 输入：restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 0, maxPrice = 50, maxDistance = 10
     * 输出：[4,3,2,1,5]
     * 解释：餐馆与示例 1 相同，但在 veganFriendly = 0 的过滤条件下，应该考虑所有餐馆。
     * 示例 3：
     *
     * 输入：restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 0, maxPrice = 30, maxDistance = 3
     * 输出：[4,5]
     *
     *
     * 提示：
     *
     * 1 <= restaurants.length <= 10^4
     * restaurants[i].length == 5
     * 1 <= idi, ratingi, pricei, distancei <= 10^5
     * 1 <= maxPrice, maxDistance <= 10^5
     * veganFriendlyi 和 veganFriendly 的值为 0 或 1 。
     * 所有 idi 各不相同。
     */
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> result = new ArrayList<>();
        if (restaurants == null || restaurants.length == 0) {
            return result;
        }

        Arrays.sort(restaurants, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] != o1[1] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });

        for (int[] res : restaurants) {
            if (res[2] >= veganFriendly && res[3] <= maxPrice && res[4] <= maxDistance) {
                result.add(res[0]);
            }
        }

        return result;
    }


    /**
     * 5321. 阈值距离内邻居最少的城市
     * 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
     *
     * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
     *
     * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
     * 输出：3
     * 解释：城市分布图如上。
     * 每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
     * 城市 0 -> [城市 1, 城市 2]
     * 城市 1 -> [城市 0, 城市 2, 城市 3]
     * 城市 2 -> [城市 0, 城市 1, 城市 3]
     * 城市 3 -> [城市 1, 城市 2]
     * 城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
     * 示例 2：
     *
     *
     *
     * 输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
     * 输出：0
     * 解释：城市分布图如上。
     * 每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
     * 城市 0 -> [城市 1]
     * 城市 1 -> [城市 0, 城市 4]
     * 城市 2 -> [城市 3, 城市 4]
     * 城市 3 -> [城市 2, 城市 4]
     * 城市 4 -> [城市 1, 城市 2, 城市 3]
     * 城市 0 在阈值距离 4 以内只有 1 个邻居城市。
     *
     *
     * 提示：
     *
     * 2 <= n <= 100
     * 1 <= edges.length <= n * (n - 1) / 2
     * edges[i].length == 3
     * 0 <= fromi < toi < n
     * 1 <= weighti, distanceThreshold <= 10^4
     * 所有 (fromi, toi) 都是不同的。
     */
    public static final int INF = 1000000;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        for (int[] g : graph) {
            Arrays.fill(g, INF);
        }

        for (int i = 0; i < n; i ++) {
            graph[i][i] = 0;
        }

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; k ++) {
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (graph[i][k] != INF && graph[k][j] != INF && graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int ans = 0;
        int count = 0;

        for (int i : graph[0]) {
            if (i <= distanceThreshold) {
                count ++;
            }
        }

        for (int i = 1; i < n; i ++) {
            int curCount = 0;
            for (int val : graph[i]) {
                if (val <= distanceThreshold) {
                    curCount ++;
                }
            }

            if (curCount <= count) {
                ans = i;
                count = curCount;
            }
        }

        return ans;
    }


    public int findTheCity1(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        ArrayList<Integer> numList = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            numList.add(getNum(i, graph, visited, distanceThreshold));
        }

        int result = numList.get(0);
        int index = 0;

        for (int i = 1; i < numList.size(); i ++) {
            System.out.println(numList.get(i));
            if (numList.get(i) <= result) {
                result = numList.get(i);
                index = i;
            }
        }

        return index;
    }

    private int getNum(int index, int[][] graph, boolean[] visited, int distanceThreshold) {
        System.out.println(distanceThreshold);

        if (distanceThreshold <= 0) {
            return 0;
        }

        int result = 0;
        int[] dis = graph[index];
        for (int i = 0; i < dis.length; i ++) {
            if (!visited[i] && dis[i] > 0 && dis[i] <= distanceThreshold) {
                visited[i] = true;
                result += (getNum(i, graph, visited, distanceThreshold - dis[i]) + 1);
            }
        }

        return result;
    }

    /**
     * 5322. 工作计划的最低难度
     *
     * 将某一段数组（字符串）分成若干段，并求某一属性（max，min，num）的动态规划模板
     * 类似的题还有1278. 分割回文串 III，813. 最大平均值和的分组、等题目
     */
    public int minDifficulty1(int[] jobDifficulty, int d) {
        if (jobDifficulty == null || d < 1 || jobDifficulty.length < d) {
            return -1;
        }

        int[][] dp = new int[jobDifficulty.length][d+1];
        dp[jobDifficulty.length - 1][1] = jobDifficulty[jobDifficulty.length - 1];

        for (int j = jobDifficulty.length - 2; j >= 0; j --) {
            dp[j][1] = Math.max(dp[j+1][1], jobDifficulty[j]);
        }

        for (int i = 2; i <= d; i ++) {
            for (int j = 0; j < jobDifficulty.length; j ++) {
                int maxDiff = jobDifficulty[j];
                dp[j][i] = Integer.MAX_VALUE / 4;

                for (int t = j; t < jobDifficulty.length; t ++) {
                    maxDiff = Math.max(maxDiff, jobDifficulty[t]);
                    dp[j][i] = Math.min(dp[j][i], maxDiff + (t + 1 < dp.length ? dp[t + 1][i - 1] : Integer.MAX_VALUE / 4));
                }
            }
        }

        return dp[0][d] >= Integer.MAX_VALUE / 4 ? -1 : dp[0][d];
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty == null || d < 1 || jobDifficulty.length < d) {
            return -1;
        }

        int[][] dp = new int[d + 1][jobDifficulty.length + 1];
        int[][] maxi = new int[310][310];

        for (int[] dpp : dp) {
            Arrays.fill(dpp, 100000);
        }

        for (int i = 0; i < jobDifficulty.length; i ++) {
            maxi[i][i] = jobDifficulty[i];
            for (int j = i + 1; j < jobDifficulty.length; j++) {
                maxi[i][j] = Math.max(maxi[i][j - 1], jobDifficulty[j]);
            }
        }

        dp[0][0] = 0;
        for (int day = 1; day <= d; day++) {
            for (int j = day; j <= jobDifficulty.length; j++) {
                for (int k = day-1; k < j; k++) {
                    dp[day][j] = Math.min(dp[day][j], dp[day - 1][k] + maxi[k][j - 1]);
                }
            }
        }
        return dp[d][jobDifficulty.length];
    }

}
