package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/5/3 9:54
 */
public class LeetcodeComp200503 {
    /**
     * 5400. 旅行终点站 显示英文描述
     * 通过的用户数875
     * 尝试过的用户数930
     * 用户总通过次数876
     * 用户总提交次数980
     * 题目难度Easy
     * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
     *
     * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
     *
     *
     *
     * 示例 1：
     *
     * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
     * 输出："Sao Paulo"
     * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
     * 示例 2：
     *
     * 输入：paths = [["B","C"],["D","B"],["C","A"]]
     * 输出："A"
     * 解释：所有可能的线路是：
     * "D" -> "B" -> "C" -> "A".
     * "B" -> "C" -> "A".
     * "C" -> "A".
     * "A".
     * 显然，旅行终点站是 "A" 。
     * 示例 3：
     *
     * 输入：paths = [["A","Z"]]
     * 输出："Z"
     *
     *
     * 提示：
     *
     * 1 <= paths.length <= 100
     * paths[i].length == 2
     * 1 <= cityAi.length, cityBi.length <= 10
     * cityAi != cityBi
     * 所有字符串均由大小写英文字母和空格字符组成。
     */
    public String destCity(List<List<String>> paths) {
        Map<String, List<String>> map = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for (List<String> path : paths) {
            String start = path.get(0);
            String end = path.get(1);
            if (!map.containsKey(start)) {
                map.put(start, new ArrayList<>());
            }

            map.get(start).add(end);
            queue.add(start);
        }

        while (!queue.isEmpty()) {
            String p = queue.pop();
            if (set.contains(p)) {
                continue;
            }

            set.add(p);

            if (!map.containsKey(p)) {
                return p;
            }

            List<String> list = map.get(p);
            queue.addAll(list);
        }

        return "";
    }


    /**
     * 5401. 是否所有 1 都至少相隔 k 个元素 显示英文描述
     * 通过的用户数877
     * 尝试过的用户数955
     * 用户总通过次数878
     * 用户总提交次数1179
     * 题目难度Medium
     * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：nums = [1,0,0,0,1,0,0,1], k = 2
     * 输出：true
     * 解释：每个 1 都至少相隔 2 个元素。
     * 示例 2：
     *
     *
     *
     * 输入：nums = [1,0,0,1,0,1], k = 2
     * 输出：false
     * 解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
     * 示例 3：
     *
     * 输入：nums = [1,1,1,1,1], k = 0
     * 输出：true
     * 示例 4：
     *
     * 输入：nums = [0,1,0,1], k = 1
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * 0 <= k <= nums.length
     * nums[i] 的值为 0 或 1
     */
    public boolean kLengthApart(int[] nums, int k) {
        if (k <= 0) {
            return true;
        }

        int tmp = -1;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 1) {
                tmp --;
            } else {
                if (tmp > 0) {
                    return false;
                }

                tmp = k;
            }
        }

        return true;
    }


    /**
     * 5402. 绝对差不超过限制的最长连续子数组 显示英文描述
     * 通过的用户数41
     * 尝试过的用户数79
     * 用户总通过次数41
     * 用户总提交次数88
     * 题目难度Medium
     * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
     *
     * 如果不存在满足条件的子数组，则返回 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [8,2,4,7], limit = 4
     * 输出：2
     * 解释：所有子数组如下：
     * [8] 最大绝对差 |8-8| = 0 <= 4.
     * [8,2] 最大绝对差 |8-2| = 6 > 4.
     * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
     * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
     * [2] 最大绝对差 |2-2| = 0 <= 4.
     * [2,4] 最大绝对差 |2-4| = 2 <= 4.
     * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
     * [4] 最大绝对差 |4-4| = 0 <= 4.
     * [4,7] 最大绝对差 |4-7| = 3 <= 4.
     * [7] 最大绝对差 |7-7| = 0 <= 4.
     * 因此，满足题意的最长子数组的长度为 2 。
     * 示例 2：
     *
     * 输入：nums = [10,1,2,4,7,2], limit = 5
     * 输出：4
     * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
     * 示例 3：
     *
     * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
     * 输出：3
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^9
     * 0 <= limit <= 10^9
     */
    public int longestSubarray(int[] nums, int limit) {
        int lower = 0;//满足条件的最小下标数组值。
        int res= 0 ;
        if(nums.length == 1) return 1;
        for(int i = 1 ; i < nums.length; ++ i){
            //队列维护
            for(int j = i - 1; j >= lower; j --){
                //如果存在相同的值，直接跳过，不处理lower
                if(nums[i] == nums[j]){
                    break;
                }
                // 从右往左处理，如果有不满足，直接更新lower.
                if(Math.abs(nums[j] - nums[i])> limit){
                    lower = j + 1;
                    break;
                }
            }
            res = Math.max(res, i - lower+ 1);
        }
        return res;
    }


    /**
     * 5403. 有序矩阵中的第 k 个最小数组和 显示英文描述
     * 通过的用户数6
     * 尝试过的用户数12
     * 用户总通过次数6
     * 用户总提交次数15
     * 题目难度Hard
     * 给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。
     *
     * 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。
     *
     *
     *
     * 示例 1：
     *
     * 输入：mat = [[1,3,11],[2,4,6]], k = 5
     * 输出：7
     * 解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
     * [1,2], [1,4], [3,2], [3,4], [1,6]。其中第 5 个的和是 7 。
     * 示例 2：
     *
     * 输入：mat = [[1,3,11],[2,4,6]], k = 9
     * 输出：17
     * 示例 3：
     *
     * 输入：mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
     * 输出：9
     * 解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
     * [1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]。其中第 7 个的和是 9 。
     * 示例 4：
     *
     * 输入：mat = [[1,1,10],[2,2,9]], k = 7
     * 输出：12
     *
     *
     * 提示：
     *
     * m == mat.length
     * n == mat.length[i]
     * 1 <= m, n <= 40
     * 1 <= k <= min(200, n ^ m)
     * 1 <= mat[i][j] <= 5000
     * mat[i] 是一个非递减数组
     */
//    public int kthSmallest(int[][] mat, int k) {
//        int n = mat.length, m = mat[0].length;
//
//        A[] dp = new A[k];
//        for (int i = 0; i < k; i ++) {
//            dp[i] = new A(0, n);
//        }
//
//        for (int i = 0; i < n; i ++) {
//            dp[0].val += mat[i][0];
//        }
//
//        for (int i = 1; i < k;) {
//            int min = Integer.MAX_VALUE;
//            A tmp = dp[i-1];
//
//            for (int j = 0; j < n; j ++) {
//                int index = tmp.indexes[j];
//                if (index >= m - 1) {
//                    continue;
//                }
//
//                int val = tmp.val + mat[j][index+1] - mat[j][index];
//                if (min > val) {
//                    min = val;
//                }
//            }
//
//            for (int j = 0; j < n; j ++) {
//                int index = tmp.indexes[j];
//                if (index >= m - 1) {
//                    continue;
//                }
//
//                int val = tmp.val + mat[j][index+1] - mat[j][index];
//                if (min == val) {
//                    dp[i].val = min;
//                    dp[i].indexes = Arrays.copyOf(tmp.indexes, n);
//                    dp[i].indexes[j] ++;
//                    i ++;
//                    if (i >= k) {
//                        break;
//                    }
//                }
//            }
//        }
//
//        return dp[k-1].val;
//    }
//
//    class A {
//        public int val;
//        public int[] indexes;
//
//        public A(int val, int n) {
//            this.val = val;
//            this.indexes = new int[n];
//        }
//    }












}
