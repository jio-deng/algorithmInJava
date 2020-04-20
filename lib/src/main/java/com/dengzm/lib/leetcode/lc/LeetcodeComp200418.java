package com.dengzm.lib.leetcode.lc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 力扣杯 CODE YOUR FUTURE
 * @date 2020/4/18 15:11
 */
public class LeetcodeComp200418 {
    /**
     * 1. 拿硬币
     * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
     *
     * 示例 1：
     *
     * 输入：[4,2,1]
     *
     * 输出：4
     *
     * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
     *
     * 示例 2：
     *
     * 输入：[2,3,10]
     *
     * 输出：8
     *
     * 限制：
     *
     * 1 <= n <= 4
     * 1 <= coins[i] <= 10
     */
    public int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            ans += (coin + 1) / 2;
        }
        return ans;
    }


    /**
     * 2. 传递信息
     * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
     *
     * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
     * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
     * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
     * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
     *
     * 示例 1：
     *
     * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
     *
     * 输出：3
     *
     * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
     *
     * 示例 2：
     *
     * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
     *
     * 输出：0
     *
     * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
     *
     * 限制：
     *
     * 2 <= n <= 10
     * 1 <= k <= 5
     * 1 <= relation.length <= 90, 且 relation[i].length == 2
     * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
     */
    public int numWays(int n, int[][] relation, int k) {
        int[][] graph = new int[n][n];
        for (int[] r : relation) {
            graph[r[0]][r[1]] = 1;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        int times = 1;

        while (times <= k && !queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int id = queue.poll();

                for (int i = 0; i < n; i ++) {
                    if (graph[id][i] == 1) {
                        queue.add(i);
                    }
                }

                size --;
            }

            times ++;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int val = queue.poll();
            if (val == n - 1) {
                ans ++;
            }
        }

        return ans;
    }


    /**
     * 3. 剧情触发时间
     * 在战略游戏中，玩家往往需要发展自己的势力来触发各种新的剧情。一个势力的主要属性有三种，分别是文明等级（C），资源储备（R）以及人口数量（H）。在游戏开始时（第 0 天），三种属性的值均为 0。
     *
     * 随着游戏进程的进行，每一天玩家的三种属性都会对应增加，我们用一个二维数组 increase 来表示每天的增加情况。这个二维数组的每个元素是一个长度为 3 的一维数组，例如 [[1,2,1],[3,4,2]] 表示第一天三种属性分别增加 1,2,1 而第二天分别增加 3,4,2。
     *
     * 所有剧情的触发条件也用一个二维数组 requirements 表示。这个二维数组的每个元素是一个长度为 3 的一维数组，对于某个剧情的触发条件 c[i], r[i], h[i]，如果当前 C >= c[i] 且 R >= r[i] 且 H >= h[i] ，则剧情会被触发。
     *
     * 根据所给信息，请计算每个剧情的触发时间，并以一个数组返回。如果某个剧情不会被触发，则该剧情对应的触发时间为 -1 。
     *
     * 示例 1：
     *
     * 输入： increase = [[2,8,4],[2,5,0],[10,9,8]] requirements = [[2,11,3],[15,10,7],[9,17,12],[8,1,14]]
     *
     * 输出: [2,-1,3,-1]
     *
     * 解释：
     *
     * 初始时，C = 0，R = 0，H = 0
     *
     * 第 1 天，C = 2，R = 8，H = 4
     *
     * 第 2 天，C = 4，R = 13，H = 4，此时触发剧情 0
     *
     * 第 3 天，C = 14，R = 22，H = 12，此时触发剧情 2
     *
     * 剧情 1 和 3 无法触发。
     *
     * 示例 2：
     *
     * 输入： increase = [[0,4,5],[4,8,8],[8,6,1],[10,10,0]] requirements = [[12,11,16],[20,2,6],[9,2,6],[10,18,3],[8,14,9]]
     *
     * 输出: [-1,4,3,3,3]
     *
     * 示例 3：
     *
     * 输入： increase = [[1,1,1]] requirements = [[0,0,0]]
     *
     * 输出: [0]
     *
     * 限制：
     *
     * 1 <= increase.length <= 10000
     * 1 <= requirements.length <= 100000
     * 0 <= increase[i] <= 10
     * 0 <= requirements[i] <= 100000
     */
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int n = increase.length;
        int[][] dp = new int[n + 1][3];
        Map<Integer, Integer>[] maps = new HashMap[3];
        for (int i = 0; i < 3; i ++) {
            maps[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i ++) {
            dp[i+1][0] = dp[i][0] + increase[i][0];
            dp[i+1][1] = dp[i][1] + increase[i][1];
            dp[i+1][2] = dp[i][2] + increase[i][2];
        }

        int start, end, max, m = requirements.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i ++) {
            int[] require = requirements[i];
            max = 0;
            for (int j = 0; j < 3; j ++) {
                if (require[j] > dp[n][j]) {
                    max = -1;
                    break;
                }
            }

            if (max != -1) {
                for (int j = 0; j < 3; j ++) {
                    if (maps[j].containsKey(require[j])) {
                        max = Math.max(max, maps[j].get(require[j]));
                    } else {
                        start = 0;
                        end = n;

                        while (start < end) {
                            int mid = start + (end - start) / 2;
                            if (require[j] <= dp[mid][j]) {
                                end = mid;
                            } else {
                                start = mid + 1;
                            }
                        }

                        maps[j].put(require[j], start);

                        max = Math.max(max, start);
                    }
                }
            }

            ans[i] = max;
        }

        return ans;
    }

    /**
     * 4. 最小跳跃次数
     * 为了给刷题的同学一些奖励，力扣团队引入了一个弹簧游戏机。游戏机由 N 个特殊弹簧排成一排，编号为 0 到 N-1。初始有一个小球在编号 0 的弹簧处。若小球在编号为 i 的弹簧处，通过按动弹簧，可以选择把小球向右弹射 jump[i] 的距离，或者向左弹射到任意左侧弹簧的位置。也就是说，在编号为 i 弹簧处按动弹簧，小球可以弹向 0 到 i-1 中任意弹簧或者 i+jump[i] 的弹簧（若 i+jump[i]>=N ，则表示小球弹出了机器）。小球位于编号 0 处的弹簧时不能再向左弹。
     *
     * 为了获得奖励，你需要将小球弹出机器。请求出最少需要按动多少次弹簧，可以将小球从编号 0 弹簧弹出整个机器，即向右越过编号 N-1 的弹簧。
     *
     * 示例 1：
     *
     * 输入：jump = [2, 5, 1, 1, 1, 1]
     *
     * 输出：3
     *
     * 解释：小 Z 最少需要按动 3 次弹簧，小球依次到达的顺序为 0 -> 2 -> 1 -> 6，最终小球弹出了机器。
     *
     * 限制：
     *
     * 1 <= jump.length <= 10^6
     * 1 <= jump[i] <= 10000
     */
    public int minJump(int[] jump) {
        int[] dp = new int[jump.length];

        dp[jump.length-1] = 1;
        for(int i=jump.length-2;i>=0;i--){
            dp[i] = jump[i] + i >= jump.length ? 1 : dp[jump[i]+i] + 1;
            //遍历当前位置更新后影响到的后面的位置，只需要更新到dp[j] >= dp[i]+1即可
            //如果遍历到某dp[j]<dp[i]+1就不需要向右遍历了,因为j到dp.length的值会被当前遍历到的dp[j]更新而不是dp[i]+1
            for(int j = i+1; j < dp.length && dp[j] >= dp[i]+1 ; j++){
                dp[j] = dp[i]+1;
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[0];
    }


//    int min = 10001;
//    public int minJump(int[] jump) {
//        int ans = 1;
//
//        int[] maxStep = new int[jump.length];
//        for (int i = 0; i < jump.length; i ++) {
//            if (i == 0) {
//                maxStep[i] = i + jump[i];
//            } else {
//                maxStep[i] = Math.max(maxStep[i-1], i + jump[i]);
//            }
//        }
//
//        minJumpCore(jump, maxStep, 0, 0);
//        return min;
//    }
//
//    private void minJumpCore(int[] jump, int[] maxStep, int cur, int ans) {
//        if (cur >= jump.length) {
//            min = Math.min(min, ans);
//            return;
//        }
//
//        if (maxStep[cur] == cur + jump[cur]) {
//            minJumpCore(jump, maxStep, maxStep[cur], ans + 1);
//        } else {
//            minJumpCore(jump, maxStep, maxStep[cur], ans + 2);
//            minJumpCore(jump, maxStep, cur + jump[cur], ans + 1);
//        }
//    }

    /**
     * 5. 二叉树任务调度
     * 任务调度优化是计算机性能优化的关键任务之一。在任务众多时，不同的调度策略可能会得到不同的总体执行时间，因此寻求一个最优的调度方案是非常有必要的。
     *
     * 通常任务之间是存在依赖关系的，即对于某个任务，你需要先完成他的前导任务（如果非空），才能开始执行该任务。我们保证任务的依赖关系是一棵二叉树，其中 root 为根任务，root.left 和 root.right 为他的两个前导任务（可能为空），root.val 为其自身的执行时间。
     *
     * 在一个 CPU 核执行某个任务时，我们可以在任何时刻暂停当前任务的执行，并保留当前执行进度。在下次继续执行该任务时，会从之前停留的进度开始继续执行。暂停的时间可以不是整数。
     *
     * 现在，系统有两个 CPU 核，即我们可以同时执行两个任务，但是同一个任务不能同时在两个核上执行。给定这颗任务树，请求出所有任务执行完毕的最小时间。
     *
     * 示例 1：
     *
     * image.png
     *
     * 输入：root = [47, 74, 31]
     *
     * 输出：121
     *
     * 解释：根节点的左右节点可以并行执行31分钟，剩下的43+47分钟只能串行执行，因此总体执行时间是121分钟。
     *
     * 示例 2：
     *
     * image.png
     *
     * 输入：root = [15, 21, null, 24, null, 27, 26]
     *
     * 输出：87
     *
     * 示例 3：
     *
     * image.png
     *
     * 输入：root = [1,3,2,null,null,4,4]
     *
     * 输出：7.5
     *
     * 限制：
     *
     * 1 <= 节点数量 <= 1000
     * 1 <= 单节点执行时间 <= 1000
     */
    public double minimalExecTime(TreeNode root) {
        double[] res = execTime(root,2);
        return res[0];
    }

    /**
     * 获取node最小执行时间
     * @param node node
     * @param n 并行数
     * @return [0]执行完当前节点最小耗时，[1]当前node为根的时间串行之和
     */
    private double[] execTime(TreeNode node,int n){
        if (node == null){
            // [0]执行完当前节点最小耗时，[1]当前node为根的时间串行之和
            return new double[]{0.0D,0.0D};
        }
        // 获取左右子树的值
        double[] leftTime = execTime(node.left,n);
        double[] rightTime = execTime(node.right,n);
        // 左右子树节点之和
        double sum = leftTime[1] + rightTime[1];
        // 当前节点执行完的最小消耗时间
        double minTime = Math.max(Math.max(leftTime[0],rightTime[0]),sum/n) + node.val;
        return new double[]{minTime,sum + node.val};
    }


//    public double minimalExecTime(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        Map<TreeNode, A> map1 = new HashMap<>();
//        Map<A, A> map2 = new HashMap<>();
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (!map1.containsKey(node)) {
//                A a = new A(node.val);
//                a.level = 0;
//                if (node.left != null) {
//                    a.unSolved ++;
//                }
//
//                if (node.right != null) {
//                    a.unSolved ++;
//                }
//
//                map1.put(node, a);
//            }
//
//            if (node.left != null) {
//                if (!map1.containsKey(node.left)) {
//                    A a = new A(node.left.val);
//                    a.level = map1.get(node).level + 1;
//                    if (node.left.left != null) {
//                        a.unSolved ++;
//                    }
//
//                    if (node.left.right != null) {
//                        a.unSolved ++;
//                    }
//
//                    map1.put(node.left, a);
//                }
//
//                map2.put(map1.get(node.left), map1.get(node));
//                queue.add(node.left);
//            }
//
//            if (node.right != null) {
//                if (!map1.containsKey(node.right)) {
//                    A a = new A(node.right.val);
//                    a.level = map1.get(node).level + 1;
//                    if (node.right.left != null) {
//                        a.unSolved ++;
//                    }
//
//                    if (node.right.right != null) {
//                        a.unSolved ++;
//                    }
//
//                    map1.put(node.right, a);
//                }
//
//                map2.put(map1.get(node.right), map1.get(node));
//                queue.add(node.right);
//            }
//        }
//
//        PriorityQueue<A> priorityQueue = new PriorityQueue<>(new Comparator<A>() {
//            @Override
//            public int compare(A a1, A a2) {
//                return a2.level != a1.level ? a2.level - a1.level : Double.compare(a2.val, a1.val);
//            }
//        });
//
//        for (Map.Entry<TreeNode, A> entry : map1.entrySet()) {
//            if (entry.getValue().unSolved == 0) {
//                priorityQueue.offer(entry.getValue());
//            }
//        }
//
//        double ans = 0;
//        while (!priorityQueue.isEmpty()) {
//            if (priorityQueue.size() > 1) {
//                A a1 = priorityQueue.poll();
//                A a2 = priorityQueue.poll();
//
//                if (a1.val == a2.val) {
//                    ans += a1.val;
//                    A father1 = map2.get(a1);
//                    if (father1 != null) {
//                        father1.unSolved --;
//                        if (father1.unSolved == 0) {
//                            priorityQueue.offer(father1);
//                        }
//                    }
//
//                    A father2 = map2.get(a2);
//                    if (father2 != null) {
//                        father2.unSolved --;
//                        if (father2.unSolved == 0) {
//                            priorityQueue.offer(father2);
//                        }
//                    }
//                } else if (a1.val < a2.val) {
//                    ans += a1.val;
//                    A father1 = map2.get(a1);
//                    if (father1 != null) {
//                        father1.unSolved --;
//                        if (father1.unSolved == 0) {
//                            priorityQueue.offer(father1);
//                        }
//                    }
//
//                    a2.val -= a1.val;
//                    priorityQueue.offer(a2);
//                } else {
//                    ans += a2.val;
//                    A father2 = map2.get(a2);
//                    if (father2 != null) {
//                        father2.unSolved --;
//                        if (father2.unSolved == 0) {
//                            priorityQueue.offer(father2);
//                        }
//                    }
//
//                    a1.val -= a2.val;
//                    priorityQueue.offer(a1);
//                }
//            } else {
//                A a = priorityQueue.poll();
//                ans += a.val;
//                A father = map2.get(a);
//                if (father != null) {
//                    father.unSolved --;
//                    if (father.unSolved == 0) {
//                        priorityQueue.offer(father);
//                    }
//                }
//            }
//        }
//
//        return ans;
//    }
//
//    class A {
//        public double val;
//        public int level;
//        public int unSolved = 0;
//
//        public A(double val) {
//            this.val = val;
//        }
//    }


    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        LeetcodeComp200418 leetcodeComp200418 = new LeetcodeComp200418();
        TreeNode node1 = new TreeNode(47);
        TreeNode node2 = new TreeNode(74);
        TreeNode node3 = new TreeNode(31);
        node1.left = node2;
        node1.right = node3;
        leetcodeComp200418.minimalExecTime(node1);
    }
}
