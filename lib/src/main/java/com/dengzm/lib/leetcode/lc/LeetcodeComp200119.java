package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/1/19 10:26
 */
public class LeetcodeComp200119 {

    /**
     * 5315. 6 和 9 组成的最大数字
     * 给你一个仅由数字 6 和 9 组成的正整数 num。
     *
     * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
     *
     * 请返回你可以得到的最大数字。
     *
     *
     *
     * 示例 1：
     *
     * 输入：num = 9669
     * 输出：9969
     * 解释：
     * 改变第一位数字可以得到 6669 。
     * 改变第二位数字可以得到 9969 。
     * 改变第三位数字可以得到 9699 。
     * 改变第四位数字可以得到 9666 。
     * 其中最大的数字是 9969 。
     * 示例 2：
     *
     * 输入：num = 9996
     * 输出：9999
     * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
     * 示例 3：
     *
     * 输入：num = 9999
     * 输出：9999
     * 解释：无需改变就已经是最大的数字了。
     *
     *
     * 提示：
     *
     * 1 <= num <= 10^4
     * num 每一位上的数字都是 6 或者 9 。
     */
    public int maximum69Number (int num) {
        if (num == 9999 || num == 999 || num == 99 || num == 9) {
            return num;
        }

        int[] nums = new int[5];
        int length = 0;
        for (int i = 0; i < 5; i ++) {
            if (num == 0) {
                break;
            }

            int wei = num % 10;

            length ++;
            nums[i] = wei;
            num /= 10;
        }

        int result = 0;
        boolean hasChanged = false;
        for (int i = length - 1; i >= 0; i --) {
            if (!hasChanged && nums[i] == 6) {
                nums[i] = 9;
                hasChanged = true;
            }

            result = result * 10 + nums[i];
        }

        return result;
    }

    /**
     * 5316. 竖直打印单词
     *
     * 给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
     * 单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
     * 每个单词只能放在一列上，每一列中也只能有一个单词。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "HOW ARE YOU"
     * 输出：["HAY","ORO","WEU"]
     * 解释：每个单词都应该竖直打印。
     *  "HAY"
     *  "ORO"
     *  "WEU"
     * 示例 2：
     *
     * 输入：s = "TO BE OR NOT TO BE"
     * 输出：["TBONTB","OEROOE","   T"]
     * 解释：题目允许使用空格补位，但不允许输出末尾出现空格。
     * "TBONTB"
     * "OEROOE"
     * "   T"
     * 示例 3：
     *
     * 输入：s = "CONTEST IS COMING"
     * 输出：["CIC","OSO","N M","T I","E N","S G","T"]
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 200
     * s 仅含大写英文字母。
     * 题目数据保证两个单词之间只有一个空格。
     */
    public List<String> printVertically(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        String[] words = s.split(" ");

        boolean complete = false;
        int curLength = 0;
        while (!complete) {
            complete = true;

            int kongge = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < words.length; i ++) {
                String ss = words[i];
                if (ss.length() > curLength) {
                    while (kongge != 0) {
                        sb.append(" ");
                        kongge --;
                    }

                    sb.append(ss.charAt(curLength));
                    complete = false;
                } else {
                    kongge ++;
                }
            }

            curLength ++;

            if (!"".equals(sb.toString().trim())) {
                result.add(sb.toString());
            }
        }

        return result;
    }

//    public List<String> printVertically1(String s) {
//        List<String> result = new ArrayList<>();
//        if (s == null || s.length() == 0) {
//            return result;
//        }
//
//        String[] words = s.split(" ");
//        HashMap<String, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < words.length; i ++) {
//            map.put(words[i], map.getOrDefault(words[i], words.length - i) + 10000);
//        }
//
//        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o2.getValue() - o1.getValue();
//            }
//        });
//
//        boolean complete = false;
//        int curLength = 0;
//        while (!complete) {
//            complete = true;
//
//            int kongge = 0;
//            StringBuilder sb = new StringBuilder();
//
//            for (int i = 0; i < list.size(); i ++) {
//                String ss = list.get(i).getKey();
//                System.out.println("ss = " + ss + ", value = " + list.get(i).getValue());
//                if (ss.length() > curLength) {
//                    while (kongge != 0) {
//                        sb.append(" ");
//                        kongge --;
//                    }
//
//                    sb.append(ss.charAt(curLength));
//                    complete = false;
//                } else {
//                    kongge ++;
//                }
//            }
//
//            curLength ++;
//
//            if (!"".equals(sb.toString().trim())) {
//                result.add(sb.toString());
//            }
//        }
//
//        return result;
//    }

    /**
     * 5317. 删除给定值的叶子节点
     * 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。
     *
     * 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。
     *
     * 也就是说，你需要重复此过程直到不能继续删除。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：root = [1,2,3,2,null,2,4], target = 2
     * 输出：[1,null,3,null,4]
     * 解释：
     * 上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
     * 有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
     * 示例 2：
     *
     *
     *
     * 输入：root = [1,3,3,3,2], target = 3
     * 输出：[1,3,null,null,2]
     * 示例 3：
     *
     *
     *
     * 输入：root = [1,2,null,2,null,2], target = 2
     * 输出：[1]
     * 解释：每一步都删除一个绿色的叶子节点（值为 2）。
     * 示例 4：
     *
     * 输入：root = [1,1,1], target = 1
     * 输出：[]
     * 示例 5：
     *
     * 输入：root = [1,2,3], target = 2
     * 输出：[1,2,3]
     *
     *
     * 提示：
     *
     * 1 <= target <= 1000
     * 每一棵树最多有 3000 个节点。
     * 每一个节点值的范围是 [1, 1000] 。
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return root;
        }

        return removeLeafCore(root, target);
    }

    private TreeNode removeLeafCore(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        node.left = removeLeafCore(node.left, target);
        node.right = removeLeafCore(node.right, target);

        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }

        return node;
    }

    /**
     * 5318. 灌溉花园的最少水龙头数目
     * 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
     *
     * 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
     *
     * 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
     *
     * 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：n = 5, ranges = [3,4,1,1,0,0]
     * 输出：1
     * 解释：
     * 点 0 处的水龙头可以灌溉区间 [-3,3]
     * 点 1 处的水龙头可以灌溉区间 [-3,5]
     * 点 2 处的水龙头可以灌溉区间 [1,3]
     * 点 3 处的水龙头可以灌溉区间 [2,4]
     * 点 4 处的水龙头可以灌溉区间 [4,4]
     * 点 5 处的水龙头可以灌溉区间 [5,5]
     * 只需要打开点 1 处的水龙头即可灌溉整个花园 [0,5] 。
     * 示例 2：
     *
     * 输入：n = 3, ranges = [0,0,0,0]
     * 输出：-1
     * 解释：即使打开所有水龙头，你也无法灌溉整个花园。
     * 示例 3：
     *
     * 输入：n = 7, ranges = [1,2,1,0,2,1,0,1]
     * 输出：3
     * 示例 4：
     *
     * 输入：n = 8, ranges = [4,0,0,0,0,0,0,0,4]
     * 输出：2
     * 示例 5：
     *
     * 输入：n = 8, ranges = [4,0,0,0,4,0,0,0,4]
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= n <= 10^4
     * ranges.length == n + 1
     * 0 <= ranges[i] <= 100
     */
    // 贪心算法：https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/solution/tan-xin-by-npe_tle/
    public int minTaps(int n, int[] ranges) {
        if (ranges == null || ranges.length == 0) {
            return -1;
        }

        Internal[] internals = new Internal[ranges.length];
        boolean[] visited = new boolean[ranges.length];

        for (int i = 0; i < ranges.length; i ++) {
            internals[i] = new Internal(i - ranges[i], i + ranges[i]);
        }

        int ans = 0;
        int from = 0;
        int maxEnd = 0;
        while (from < n) {
            int index = -1;

            for (int i = 0; i < internals.length; i ++) {
                if (!visited[i] && internals[i].start <= from && internals[i].end > maxEnd) {
                    index = i;
                    maxEnd = internals[i].end;
                }
            }

            if (index == -1) {
                return -1;
            }

            ans ++;
            visited[index] = true;
            from = maxEnd;
        }

        return ans;
    }

    class Internal {
        int start;
        int end;

        public Internal(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }



    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        LeetcodeComp200119 leetcodeComp200119 = new LeetcodeComp200119();
//        List<String> result = leetcodeComp200119.printVertically("TO BE OR NOT TO BE");
//        for (String s : result) {
//            System.out.println(s);
//        }
//        int n = 5;
//        int[] range = new int[] {3,4,1,1,0,0};

        int n = 35;
        int[] range = new int[] {1,0,4,0,4,1,4,3,1,1,1,2,1,4,0,3,0,3,0,3,0,5,3,0,0,1,2,1,2,4,3,0,1,0,5,2};
        System.out.println(leetcodeComp200119.minTaps(n, range));
    }




}
