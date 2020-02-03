package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/2/2 9:34
 */
public class LeetcodeComp200202 {
    /**
     * 5328. 方阵中战斗力最弱的 K 行
     * 给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 0 和 1 表示。
     *
     * 请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
     *
     * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
     *
     * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
     *
     *
     *
     * 示例 1：
     *
     * 输入：mat =
     * [[1,1,0,0,0],
     *  [1,1,1,1,0],
     *  [1,0,0,0,0],
     *  [1,1,0,0,0],
     *  [1,1,1,1,1]],
     * k = 3
     * 输出：[2,0,3]
     * 解释：
     * 每行中的军人数目：
     * 行 0 -> 2
     * 行 1 -> 4
     * 行 2 -> 1
     * 行 3 -> 2
     * 行 4 -> 5
     * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
     * 示例 2：
     *
     * 输入：mat =
     * [[1,0,0,0],
     *  [1,1,1,1],
     *  [1,0,0,0],
     *  [1,0,0,0]],
     * k = 2
     * 输出：[0,2]
     * 解释：
     * 每行中的军人数目：
     * 行 0 -> 1
     * 行 1 -> 4
     * 行 2 -> 1
     * 行 3 -> 1
     * 从最弱到最强对这些行排序后得到 [0,2,3,1]
     *
     *
     * 提示：
     *
     * m == mat.length
     * n == mat[i].length
     * 2 <= n, m <= 100
     * 1 <= k <= m
     * matrix[i][j] 不是 0 就是 1
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        if (k < 1 || mat == null || mat.length == 0 || mat[0].length == 0) {
            return null;
        }

        int[] result = new int[k];

        ArrayList<People> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i ++) {
            int power = 0;
            int[] ps = mat[i];
            for (int n : ps) {
                if (n == 1) {
                    power ++;
                }
            }

            list.add(new People(i, power));
        }

        list.sort(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.power - o2.power != 0 ? o1.power - o2.power : o1.row - o2.row;
            }
        });

        for (int i = 0; i < k; i ++) {
            result[i] = list.get(i).row;
        }

        return result;
    }

    class People {
        public int row;
        public int power;

        public People(int row, int power) {
            this.row = row;
            this.power = power;
        }
    }

    /**
     * 5329. 数组大小减半
     * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
     *
     * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
     *
     *
     *
     * 示例 1：
     *
     * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
     * 输出：2
     * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
     * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
     * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
     * 示例 2：
     *
     * 输入：arr = [7,7,7,7,7,7]
     * 输出：1
     * 解释：我们只能选择集合 {7}，结果数组为空。
     * 示例 3：
     *
     * 输入：arr = [1,9]
     * 输出：1
     * 示例 4：
     *
     * 输入：arr = [1000,1000,3,7]
     * 输出：1
     * 示例 5：
     *
     * 输入：arr = [1,2,3,4,5,6,7,8,9,10]
     * 输出：5
     *
     *
     * 提示：
     *
     * 1 <= arr.length <= 10^5
     * arr.length 为偶数
     * 1 <= arr[i] <= 10^5
     */
    public int minSetSize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int aimLength = (arr.length + 1) / 2;

        int result = 0;
        int curLength = 0;
        for (int i = 0; i < list.size(); i ++) {
            curLength += list.get(i);
            result ++;
            if (curLength >= aimLength) {
                break;
            }
        }

        return result;
    }

    /**
     * 5330. 分裂二叉树的最大乘积
     * 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
     *
     * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：root = [1,2,3,4,5,6]
     * 输出：110
     * 解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
     * 示例 2：
     *
     *
     *
     * 输入：root = [1,null,2,3,4,null,null,5,6]
     * 输出：90
     * 解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
     * 示例 3：
     *
     * 输入：root = [2,3,9,10,7,8,6,5,4,11,1]
     * 输出：1025
     * 示例 4：
     *
     * 输入：root = [1,1]
     * 输出：1
     *
     *
     * 提示：
     *
     * 每棵树最多有 50000 个节点，且至少有 2 个节点。
     * 每个节点的值在 [1, 10000] 之间。
     */
    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }

        map.clear();

        TreeNode node = root;
        collectAllVal(node);

        long maxVal = 0;
        long leftRootVal = 0;

        while (root != null) {
            long rootVal = (root.val + leftRootVal) % M;
            long leftVal = (root.left != null ? map.get(root.left) : 0) % M;
            long rightVal = (root.right != null ? map.get(root.right) : 0) % M;

            long minner = leftVal > rightVal ? rightVal : leftVal;
            long bigger = leftVal > rightVal ? leftVal : rightVal;

            if ((rootVal + minner) * bigger >= maxVal) {
                maxVal = (rootVal + minner) * bigger;
                root = leftVal > rightVal ? root.left : root.right;
                leftRootVal = rootVal + minner;
            } else {
                break;
            }
        }

        return (int) (maxVal % M);
    }

    private long collectAllVal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        long val = root.val % M;
        long leftVal = (root.left != null ? (map.containsKey(root.left) ? map.get(root.left) : collectAllVal(root.left)) : 0 ) % M;
        long rightVal = (root.right != null ? (map.containsKey(root.right) ? map.get(root.right) : collectAllVal(root.right)) : 0 ) % M;
        long allVal = (val + leftVal + rightVal) % M;

        map.put(root, allVal);

        return allVal;
    }

    private int M = 1000000007;
    private HashMap<TreeNode, Long> map = new HashMap<>();


    /**
     * 5331. 跳跃游戏 V
     * 给你一个整数数组 arr 和一个整数 d 。每一步你可以从下标 i 跳到：
     *
     * i + x ，其中 i + x < arr.length 且 0 < x <= d 。
     * i - x ，其中 i - x >= 0 且 0 < x <= d 。
     * 除此以外，你从下标 i 跳到下标 j 需要满足：arr[i] > arr[j] 且 arr[i] > arr[k] ，其中下标 k 是所有 i 到 j 之间的数字（更正式的，min(i, j) < k < max(i, j)）。
     *
     * 你可以选择数组的任意下标开始跳跃。请你返回你 最多 可以访问多少个下标。
     *
     * 请注意，任何时刻你都不能跳到数组的外面。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
     * 输出：4
     * 解释：你可以从下标 10 出发，然后如上图依次经过 10 --> 8 --> 6 --> 7 。
     * 注意，如果你从下标 6 开始，你只能跳到下标 7 处。你不能跳到下标 5 处因为 13 > 9 。你也不能跳到下标 4 处，因为下标 5 在下标 4 和 6 之间且 13 > 9 。
     * 类似的，你不能从下标 3 处跳到下标 2 或者下标 1 处。
     * 示例 2：
     *
     * 输入：arr = [3,3,3,3,3], d = 3
     * 输出：1
     * 解释：你可以从任意下标处开始且你永远无法跳到任何其他坐标。
     * 示例 3：
     *
     * 输入：arr = [7,6,5,4,3,2,1], d = 1
     * 输出：7
     * 解释：从下标 0 处开始，你可以按照数值从大到小，访问所有的下标。
     * 示例 4：
     *
     * 输入：arr = [7,1,7,1,7,1], d = 2
     * 输出：2
     * 示例 5：
     *
     * 输入：arr = [66], d = 1
     * 输出：1
     *
     * 1 <= arr.length <= 1000
     * 1 <= arr[i] <= 10^5
     * 1 <= d <= arr.length
     */
    public int maxJumps(int[] arr, int d) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        if (arr.length == 1) {
            return 1;
        }

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        int max = 1;
        for (int i = 0; i < arr.length; i ++) {
            int tempMax = maxJumpsCore(arr, i, d, dp);

            if (tempMax > max) {
                max = tempMax;
            }
        }

        return max;
    }

    public int maxJumpsCore(int[] arr, int cur, int d, int[] dp) {
        if (dp[cur] != -1) {
            return dp[cur];
        }

        int maxVisited = 1;

        int left = cur - d;
        int right = cur + d;

        // 向左
        for (int j = cur - 1; j >= left; j --) {
            if (j < 0 || arr[j] >= arr[cur]) {
                break;
            }

            int tempMax = maxJumpsCore(arr, j, d, dp) + 1;
            if (tempMax > maxVisited) {
                maxVisited = tempMax;
            }
        }

        // 向右
        for (int j = cur + 1; j <= right; j ++) {
            if (j >= arr.length || arr[j] >= arr[cur]) {
                break;
            }

            int tempMax = maxJumpsCore(arr, j, d, dp) + 1;
            if (tempMax > maxVisited) {
                maxVisited = tempMax;
            }
        }

        dp[cur] = maxVisited;
        return maxVisited;
    }







    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        LeetcodeComp200202 leetcodeComp200202 = new LeetcodeComp200202();
//        leetcodeComp200202.kWeakestRows(new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}}, 3);
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        leetcodeComp200202.maxProduct(root);
        System.out.println(leetcodeComp200202.maxJumps(new int[] {83,11,83,70,75,45,96,11,80,75,67,83,6,51,71,64,64,42,70,23,11,24,95,65,1,54,31,50,18,16,11,86,2,48,37,34,65,67,4,17,33,70,16,73,57,96,30,26,56,1,16,74,82,77,82,62,32,90,94,33,58,23,23,65,70,12,85,27,38,100,93,49,96,96,77,37,69,71,62,34,4,14,25,37,70,3,67,88,20,30}, 29));

    }

}
