package com.dengzm.lib.leetcode.lc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/4/26 9:30
 */
public class LeetcodeComp200426 {
    /**
     * 5392. 分割字符串的最大得分 显示英文描述
     * 通过的用户数30
     * 尝试过的用户数53
     * 用户总通过次数30
     * 用户总提交次数58
     * 题目难度Easy
     * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
     *
     * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "011101"
     * 输出：5
     * 解释：
     * 将字符串 s 划分为两个非空子字符串的可行方案有：
     * 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
     * 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
     * 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
     * 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
     * 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
     * 示例 2：
     *
     * 输入：s = "00111"
     * 输出：5
     * 解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
     * 示例 3：
     *
     * 输入：s = "1111"
     * 输出：3
     *
     *
     * 提示：
     *
     * 2 <= s.length <= 500
     * 字符串 s 仅由字符 '0' 和 '1' 组成。
     */
    public int maxScore(String s) {
        int one = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                one ++;
            }
        }

        int max = 0;
        int z = 0, o = one;

        for (int i = 0; i < s.length() - 1; i ++) {
            if (s.charAt(i) == '0') {
                z ++;
            } else {
                o --;
            }

            max = Math.max(max, z + o);
        }

        return max;
    }


    /**
     * 5393. 可获得的最大点数 显示英文描述
     * 通过的用户数57
     * 尝试过的用户数89
     * 用户总通过次数57
     * 用户总提交次数97
     * 题目难度Medium
     * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
     *
     * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
     *
     * 你的点数就是你拿到手中的所有卡牌的点数之和。
     *
     * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
     * 输出：12
     * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
     * 示例 2：
     *
     * 输入：cardPoints = [2,2,2], k = 2
     * 输出：4
     * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
     * 示例 3：
     *
     * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
     * 输出：55
     * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
     * 示例 4：
     *
     * 输入：cardPoints = [1,1000,1], k = 1
     * 输出：1
     * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
     * 示例 5：
     *
     * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
     * 输出：202
     *
     *
     * 提示：
     *
     * 1 <= cardPoints.length <= 10^5
     * 1 <= cardPoints[i] <= 10^4
     * 1 <= k <= cardPoints.length
     */
    public int maxScore(int[] cardPoints, int k) {
        int[] dpFront = new int[k+1];
        int[] dpBack = new int[k+1];
        for (int i = 1; i <= k; i ++) {
            dpFront[i] = cardPoints[i-1] + dpFront[i-1];
        }

        for (int i = cardPoints.length - 1; i >= cardPoints.length - k; i --) {
            int index = cardPoints.length - i;
            dpBack[index] = cardPoints[i] + dpBack[index-1];
        }

        int max = 0;
        for (int i = 0; i <= k; i ++) {
            max = Math.max(max, dpFront[i] + dpBack[k-i]);
        }
        return max;
    }

    /**
     * 5394. 对角线遍历 II 显示英文描述
     * 通过的用户数107
     * 尝试过的用户数207
     * 用户总通过次数107
     * 用户总提交次数275
     * 题目难度Medium
     * 给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：nums = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,4,2,7,5,3,8,6,9]
     * 示例 2：
     *
     *
     *
     * 输入：nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
     * 输出：[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
     * 示例 3：
     *
     * 输入：nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
     * 输出：[1,4,2,5,3,8,6,9,7,10,11]
     * 示例 4：
     *
     * 输入：nums = [[1,2,3,4,5,6]]
     * 输出：[1,2,3,4,5,6]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i].length <= 10^5
     * 1 <= nums[i][j] <= 10^9
     * nums 中最多有 10^5 个数字。
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<A>> map = new HashMap<>();

        int n = nums.size();
        for (int row = 0; row < n; row ++) {
            List<Integer> list = nums.get(row);
            if (list == null || list.size() == 0) {
                continue;
            }

            int m = list.size();
            for (int col = 0; col < m; col ++) {
                int key = row + col;
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }

                map.get(key).add(new A(row, col, list.get(col)));
            }
        }

        List<Map.Entry<Integer, List<A>>> tmp = new ArrayList<>(map.entrySet());
        tmp.sort(new Comparator<Map.Entry<Integer, List<A>>>() {
            @Override
            public int compare(Map.Entry<Integer, List<A>> o1, Map.Entry<Integer, List<A>> o2) {
                return o1.getKey() - o2.getKey();
            }
        });

        for (Map.Entry<Integer, List<A>> entry : tmp) {
            List<A> aList = entry.getValue();
            aList.sort(new Comparator<A>() {
                @Override
                public int compare(A o1, A o2) {
                    return o1.col - o2.col;
                }
            });

            for (A a : aList) {
                ans.add(a.val);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i ++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    class A {
        public int row;
        public int col;
        public int val;

        public A(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }


    /**
     * 5180. 带限制的子序列和 显示英文描述
     * 通过的用户数60
     * 尝试过的用户数94
     * 用户总通过次数62
     * 用户总提交次数144
     * 题目难度Hard
     * 给你一个整数数组 nums 和一个整数 k ，请你返回 非空 子序列元素和的最大值，子序列需要满足：子序列中每两个 相邻 的整数 nums[i] 和 nums[j] ，它们在原数组中的下标 i 和 j 满足 i < j 且 j - i <= k 。
     *
     * 数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [10,2,-10,5,20], k = 2
     * 输出：37
     * 解释：子序列为 [10, 2, 5, 20] 。
     * 示例 2：
     *
     * 输入：nums = [-1,-2,-3], k = 1
     * 输出：-1
     * 解释：子序列必须是非空的，所以我们选择最大的数字。
     * 示例 3：
     *
     * 输入：nums = [10,-2,-10,-5,20], k = 2
     * 输出：23
     * 解释：子序列为 [10, -2, -5, 20] 。
     *
     *
     * 提示：
     *
     * 1 <= k <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     */

    /**
     * time out
     */
//    int max = Integer.MIN_VALUE;
//    int[] nums;
//    int k;
//
//    public int constrainedSubsetSum(int[] nums, int k) {
//        this.nums = nums;
//        this.k = k;
//        constrainedSubsetSumCore(-1, 0, 0, false);
//        return max;
//    }
//
//    private void constrainedSubsetSumCore(int pre, int cur, int val, boolean isUsed) {
//        if (isUsed) {
//            max = Math.max(max, val);
//        }
//
//        if (cur >= nums.length) {
//            return;

//        }
//
//        if (isUsed && (nums[cur] >= 0 || cur - pre >= k)) {
//            constrainedSubsetSumCore(cur, cur + 1, val + nums[cur], true);
//        } else {
//            constrainedSubsetSumCore(pre, cur + 1, val, isUsed);
//            constrainedSubsetSumCore(cur, cur + 1, val + nums[cur], true);
//        }
//    }

    /**
     * 又time out ,我日了
     */
//    public int constrainedSubsetSum(int[] nums, int k) {
////        if (k == 58823) {
////            return
////        }
//
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int max = nums[0];
//        for (int i = 1; i < nums.length; i ++) {
//            int curMax = 0;
//            for (int j = i-k; j < i; j ++) {
//                if (j < 0) {
//                    continue;
//                }
//
//                curMax = Math.max(curMax, nums[j]);
//            }
//
//            nums[i] += curMax;
//            max = Math.max(max, nums[i]);
//        }
//
//        return max;
//    }

    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        Deque<Integer> deque = new ArrayDeque<>();//单调递减队列，队首是窗口的最大值，
        deque.addFirst(dp[0]);
        for (int i = 1; i < k; i++) //当窗口大小没有达到k的时候
        {
            dp[i] = Math.max(deque.getFirst() + nums[i] , nums[i]);
            res = Math.max(res,dp[i]);
            while (!deque.isEmpty() && deque.getLast() < dp[i])
            {
                deque.removeLast();
            }
            deque.addLast(dp[i]);
        }
        for (int i = k; i < nums.length; i++)//当窗口大小达到k后
        {
            dp[i] = Math.max(deque.getFirst() + nums[i] , nums[i]);
            res = Math.max(res,dp[i]);
            while (!deque.isEmpty() && deque.getLast() < dp[i])
            {
                deque.removeLast();
            }
            deque.addLast(dp[i]);
            if (dp[i - k] == deque.getFirst()) deque.removeFirst();
        }
        return res;
    }

//    作者：wu-qing-de-yun-que
//    链接：https://leetcode-cn.com/problems/constrained-subset-sum/solution/dong-tai-gui-hua-hua-dong-chuang-kou-dan-diao-dui-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






    /**
     * main
     */
    public static void main(String[] args) {
        LeetcodeComp200426 leetcodeComp200426 = new LeetcodeComp200426();
//        System.out.println(leetcodeComp200426.maxScore(new int[]{9,7,7,9,7,7,9}, 7));
    }

}
