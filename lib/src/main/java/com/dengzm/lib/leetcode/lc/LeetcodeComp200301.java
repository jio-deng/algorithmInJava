package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/3/1 19:58
 */
public class LeetcodeComp200301 {
    /**
     * 5344. 有多少小于当前数字的数字
     * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     *
     * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
     *
     * 以数组形式返回答案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [8,1,2,2,3]
     * 输出：[4,0,1,1,3]
     * 解释：
     * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
     * 对于 nums[1]=1 不存在比它小的数字。
     * 对于 nums[2]=2 存在一个比它小的数字：（1）。
     * 对于 nums[3]=2 存在一个比它小的数字：（1）。
     * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
     * 示例 2：
     *
     * 输入：nums = [6,5,4,8]
     * 输出：[2,1,0,3]
     * 示例 3：
     *
     * 输入：nums = [7,7,7,7]
     * 输出：[0,0,0,0]
     *  
     *
     * 提示：
     *
     * 2 <= nums.length <= 500
     * 0 <= nums[i] <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        int[] copy = Arrays.copyOf(nums, nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(copy);
        for (int i = 0; i < nums.length; i ++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], i);
            }
        }

        for (int i = 0; i < nums.length; i ++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }

    /**
     * 5345. 通过投票对团队排名
     * 现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，每个投票者都需要按从高到低的顺序对参与排名的所有团队进行排位。
     *
     * 排名规则如下：
     *
     * 参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况，将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
     * 如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
     * 给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。
     *
     * 请你返回能表示按排名系统 排序后 的所有团队排名的字符串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：votes = ["ABC","ACB","ABC","ACB","ACB"]
     * 输出："ACB"
     * 解释：A 队获得五票「排位第一」，没有其他队获得「排位第一」，所以 A 队排名第一。
     * B 队获得两票「排位第二」，三票「排位第三」。
     * C 队获得三票「排位第二」，两票「排位第三」。
     * 由于 C 队「排位第二」的票数较多，所以 C 队排第二，B 队排第三。
     * 示例 2：
     *
     * 输入：votes = ["WXYZ","XYZW"]
     * 输出："XWYZ"
     * 解释：X 队在并列僵局打破后成为排名第一的团队。X 队和 W 队的「排位第一」票数一样，但是 X 队有一票「排位第二」，而 W 没有获得「排位第二」。
     * 示例 3：
     *
     * 输入：votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
     * 输出："ZMNAGUEDSJYLBOPHRQICWFXTVK"
     * 解释：只有一个投票者，所以排名完全按照他的意愿。
     * 示例 4：
     *
     * 输入：votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
     * 输出："ABC"
     * 解释：
     * A 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
     * B 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
     * C 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
     * 完全并列，所以我们需要按照字母升序排名。
     * 示例 5：
     *
     * 输入：votes = ["M","M","M","M"]
     * 输出："M"
     * 解释：只有 M 队参赛，所以它排名第一。
     *  
     *
     * 提示：
     *
     * 1 <= votes.length <= 1000
     * 1 <= votes[i].length <= 26
     * votes[i].length == votes[j].length for 0 <= i, j < votes.length
     * votes[i][j] 是英文 大写 字母
     * votes[i] 中的所有字母都是唯一的
     * votes[0] 中出现的所有字母 同样也 出现在 votes[j] 中，其中 1 <= j < votes.length
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rank-teams-by-votes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String rankTeams(String[] votes) {
        //key是参赛团队，value是该团队每个排位获得的票数
        Map<Character, int[]> teamRankMap = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                int[] rankArr = teamRankMap.getOrDefault(vote.charAt(i), new int[26]);
                rankArr[i]++;
                teamRankMap.put(vote.charAt(i), rankArr);
            }
        }

        List<Map.Entry<Character, int[]>> teamRankList = new ArrayList<>(teamRankMap.entrySet());
        Collections.sort(teamRankList, new Comparator<Map.Entry<Character, int[]>>() {
            @Override
            public int compare(Map.Entry<Character, int[]> team1, Map.Entry<Character, int[]> team2) {
                int[] ranks1 = team1.getValue();
                int[] ranks2 = team2.getValue();
                //根据投票排序
                for (int i = 0; i < 26; i++) {
                    if (ranks1[i] != ranks2[i]) {
                        return ranks2[i] - ranks1[i];
                    }
                }
                //字母顺序排序
                return team1.getKey() - team2.getKey();
            }
        });

        //转换为字符串输出
        return teamRankList.stream().map(entry -> String.valueOf(entry.getKey())).collect(Collectors.joining());
    }

    /**
     * 5346. 二叉树中的列表
     * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
     *
     * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
     *
     * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
     * 输出：true
     * 解释：树中蓝色的节点构成了与链表对应的子路径。
     * 示例 2：
     *
     *
     *
     * 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
     * 输出：true
     * 示例 3：
     *
     * 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
     * 输出：false
     * 解释：二叉树中不存在一一对应链表的路径。
     *  
     *
     * 提示：
     *
     * 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
     * 链表包含的节点数目在 1 到 100 之间。
     * 二叉树包含的节点数目在 1 到 2500 之间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-in-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        return isSubPathCore(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isSubPathCore(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null || head.val != root.val) {
            return false;
        }

        return isSubPathCore(head.next, root.left) || isSubPathCore(head.next, root.right);
    }

    /**
     * 5347. 使网格图至少有一条有效路径的最小代价
     * 给你一个 m x n 的网格图 grid 。 grid 中每个格子都有一个数字，对应着从该格子出发下一步走的方向。 grid[i][j] 中的数字可能为以下几种情况：
     *
     * 1 ，下一步往右走，也就是你会从 grid[i][j] 走到 grid[i][j + 1]
     * 2 ，下一步往左走，也就是你会从 grid[i][j] 走到 grid[i][j - 1]
     * 3 ，下一步往下走，也就是你会从 grid[i][j] 走到 grid[i + 1][j]
     * 4 ，下一步往上走，也就是你会从 grid[i][j] 走到 grid[i - 1][j]
     * 注意网格图中可能会有 无效数字 ，因为它们可能指向 grid 以外的区域。
     *
     * 一开始，你会从最左上角的格子 (0,0) 出发。我们定义一条 有效路径 为从格子 (0,0) 出发，每一步都顺着数字对应方向走，最终在最右下角的格子 (m - 1, n - 1) 结束的路径。有效路径 不需要是最短路径 。
     *
     * 你可以花费 cost = 1 的代价修改一个格子中的数字，但每个格子中的数字 只能修改一次 。
     *
     * 请你返回让网格图至少有一条有效路径的最小代价。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
     * 输出：3
     * 解释：你将从点 (0, 0) 出发。
     * 到达 (3, 3) 的路径为： (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) 花费代价 cost = 1 使方向向下 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) 花费代价 cost = 1 使方向向下 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) 花费代价 cost = 1 使方向向下 --> (3, 3)
     * 总花费为 cost = 3.
     * 示例 2：
     *
     *
     *
     * 输入：grid = [[1,1,3],[3,2,2],[1,1,4]]
     * 输出：0
     * 解释：不修改任何数字你就可以从 (0, 0) 到达 (2, 2) 。
     * 示例 3：
     *
     *
     *
     * 输入：grid = [[1,2],[4,3]]
     * 输出：1
     * 示例 4：
     *
     * 输入：grid = [[2,2,2],[2,2,2]]
     * 输出：3
     * 示例 5：
     *
     * 输入：grid = [[4]]
     * 输出：0
     *  
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static final int INF = 0x3f3f3f3f;
    private static final int[] dx = new int[] {0, 1, -1, 0, 0};
    private static final int[] dy = new int[] {0, 0, 0, 1, -1};

    class Pair {
        public int step;
        public int pos;

        public Pair(int step, int pos) {
            this.step = step;
            this.pos = pos;
        }
    }

    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dict = new int[n][m];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(dict[i], INF);
        }

        dict[0][0] = 0;

        boolean[] isVisited = new boolean[m * n];
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.step - o2.step;
            }
        });
        queue.offer(new Pair(dict[0][0], 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (isVisited[pair.pos]) {
                continue;
            }
            isVisited[pair.pos] = true;

            int x = pair.pos % m, y = pair.pos / m;

            for (int k = 1; k <= 4; k ++) {
                int nx = x + dx[k], ny = y + dy[k];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                int steps = pair.step + (grid[y][x] == k ? 0 : 1);
                if (steps < dict[ny][nx]) {
                    dict[ny][nx] = steps;
                    queue.offer(new Pair(dict[ny][nx], ny * m + nx));
                }
            }
        }

//        for (int r = 0; r < n; r ++) {
//            for (int c = 0; c < m; c ++) {
//                System.out.print(dict[r][c] + " ");
//            }
//            System.out.println();
//        }

        return dict[n-1][m-1];
    }

}
