package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/4/5 10:06
 */
public class LeetcodeComp200405 {
    /**
     * 5376. 非递增顺序的最小子序列 显示英文描述
     * 用户通过次数1
     * 用户尝试次数4
     * 通过次数1
     * 提交次数4
     * 题目难度Easy
     * 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
     *
     * 如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
     *
     * 与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
     *
     * 注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [4,3,10,9,8]
     * 输出：[10,9]
     * 解释：子序列 [10,9] 和 [10,8] 是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。
     * 示例 2：
     *
     * 输入：nums = [4,4,7,6,7]
     * 输出：[7,7,6]
     * 解释：子序列 [7,7] 的和为 14 ，不严格大于剩下的其他元素之和（14 = 4 + 4 + 6）。因此，[7,6,7] 是满足题意的最小子序列。注意，元素按非递增顺序返回。
     * 示例 3：
     *
     * 输入：nums = [6]
     * 输出：[6]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 500
     * 1 <= nums[i] <= 100
     */
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int cur = 0;
        for (int i = nums.length - 1; i >= 0; i --) {
            cur += nums[i];
            ans.add(nums[i]);
            if (cur * 2 > sum) {
                break;
            }
        }

        return ans;
    }


    /**
     * 5377. 将二进制表示减到 1 的步骤数 显示英文描述
     * 用户通过次数14
     * 用户尝试次数21
     * 通过次数14
     * 提交次数25
     * 题目难度Medium
     * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
     *
     * 如果当前数字为偶数，则将其除以 2 。
     *
     * 如果当前数字为奇数，则将其加上 1 。
     *
     * 题目保证你总是可以按上述规则将测试用例变为 1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "1101"
     * 输出：6
     * 解释："1101" 表示十进制数 13 。
     * Step 1) 13 是奇数，加 1 得到 14
     * Step 2) 14 是偶数，除 2 得到 7
     * Step 3) 7  是奇数，加 1 得到 8
     * Step 4) 8  是偶数，除 2 得到 4
     * Step 5) 4  是偶数，除 2 得到 2
     * Step 6) 2  是偶数，除 2 得到 1
     * 示例 2：
     *
     * 输入：s = "10"
     * 输出：1
     * 解释："10" 表示十进制数 2 。
     * Step 1) 2 是偶数，除 2 得到 1
     * 示例 3：
     *
     * 输入：s = "1"
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 500
     * s 由字符 '0' 或 '1' 组成。
     * s[0] == '1'
     */
    public int numSteps(String s) {
        if (s.length() == 1) {
            return 0;
        }

        int ans = 0, extra = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            if (i == 0 && extra == 0) {
                break;
            }

            if (s.charAt(i) == '1') {
                if (extra == 0) {
                    ans += 2;
                    extra = 1;
                } else {
                    ans += 1;
                }
            } else {
                if (extra == 0) {
                    ans += 1;
                } else {
                    ans += 2;
                }
            }
        }

        return ans;
    }


    /**
     * 5195. 最长快乐字符串 显示英文描述
     * 用户通过次数2
     * 用户尝试次数4
     * 通过次数2
     * 提交次数4
     * 题目难度Medium
     * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
     *
     * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
     *
     * s 是一个尽可能长的快乐字符串。
     * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
     * s 中只含有 'a'、'b' 、'c' 三种字母。
     * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
     *
     *
     *
     * 示例 1：
     *
     * 输入：a = 1, b = 1, c = 7
     * 输出："ccaccbcc"
     * 解释："ccbccacc" 也是一种正确答案。
     * 示例 2：
     *
     * 输入：a = 2, b = 2, c = 1
     * 输出："aabbc"
     * 示例 3：
     *
     * 输入：a = 7, b = 1, c = 0
     * 输出："aabaa"
     * 解释：这是该测试用例的唯一正确答案。
     *
     *
     * 提示：
     *
     * 0 <= a, b, c <= 100
     * a + b + c > 0
     */
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        Integer[] order = new Integer[3];
        char[] chars = new char[3];
        boolean[] isUsed = new boolean[3];
        order[0] = a;
        order[1] = b;
        order[2] = c;
        Arrays.sort(order, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if (a == order[0]) {
            chars[0] = 'a';
            isUsed[0] = true;
        } else if (b == order[0]) {
            chars[0] = 'b';
            isUsed[1] = true;
        } else {
            chars[0] = 'c';
            isUsed[2] = true;
        }

        if (a == order[1] && !isUsed[0]) {
            chars[1] = 'a';
            isUsed[0] = true;
        } else if (b == order[1] && !isUsed[1]) {
            chars[1] = 'b';
            isUsed[1] = true;
        } else {
            chars[1] = 'c';
            isUsed[2] = true;
        }

        if (a == order[2] && !isUsed[0]) {
            chars[2] = 'a';
            isUsed[0] = true;
        } else if (b == order[2] && !isUsed[1]) {
            chars[2] = 'b';
            isUsed[1] = true;
        } else {
            chars[2] = 'c';
            isUsed[2] = true;
        }

        int sum = a + b + c;
        char pre = '0';
        while (sum > 0) {
            boolean flag = false;
            for (int i = 0; i < 3; i ++) {
                if (pre == chars[i] || order[i] == 0) {
                    continue;
                }

                if (order[i] / 2 > order[(i+1) % 3] + order[(i+2) % 3] && order[i] >= 2) {
                    sb.append(chars[i]).append(chars[i]);
                    order[i] -= 2;
                    sum -= 2;
                } else {
                    sb.append(chars[i]);
                    order[i] --;
                    sum --;
                }

                flag = true;
                pre = chars[i];
                break;
            }

            if (!flag) {
                break;
            }

            if (order[1] > order[0]) {
                int tmp = order[0];
                order[0] = order[1];
                order[1] = tmp;

                char ct = chars[0];
                chars[0] = chars[1];
                chars[1] = ct;
            }

            if (order[2] > order[1]) {
                int tmp = order[2];
                order[2] = order[1];
                order[1] = tmp;

                char ct = chars[2];
                chars[2] = chars[1];
                chars[1] = ct;
            }

            if (order[1] > order[0]) {
                int tmp = order[0];
                order[0] = order[1];
                order[1] = tmp;

                char ct = chars[0];
                chars[0] = chars[1];
                chars[1] = ct;
            }
        }

        return sb.toString();
    }


    /**
     * 5379. 石子游戏 III 显示英文描述
     * 用户通过次数38
     * 用户尝试次数48
     * 通过次数39
     * 提交次数61
     * 题目难度Hard
     * Alice 和 Bob 用几堆石子在做游戏。几堆石子排成一行，每堆石子都对应一个得分，由数组 stoneValue 给出。
     *
     * Alice 和 Bob 轮流取石子，Alice 总是先开始。在每个玩家的回合中，该玩家可以拿走剩下石子中的的前 1、2 或 3 堆石子 。比赛一直持续到所有石头都被拿走。
     *
     * 每个玩家的最终得分为他所拿到的每堆石子的对应得分之和。每个玩家的初始分数都是 0 。比赛的目标是决出最高分，得分最高的选手将会赢得比赛，比赛也可能会出现平局。
     *
     * 假设 Alice 和 Bob 都采取 最优策略 。如果 Alice 赢了就返回 "Alice" ，Bob 赢了就返回 "Bob"，平局（分数相同）返回 "Tie" 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：values = [1,2,3,7]
     * 输出："Bob"
     * 解释：Alice 总是会输，她的最佳选择是拿走前三堆，得分变成 6 。但是 Bob 的得分为 7，Bob 获胜。
     * 示例 2：
     *
     * 输入：values = [1,2,3,-9]
     * 输出："Alice"
     * 解释：Alice 要想获胜就必须在第一个回合拿走前三堆石子，给 Bob 留下负分。
     * 如果 Alice 只拿走第一堆，那么她的得分为 1，接下来 Bob 拿走第二、三堆，得分为 5 。之后 Alice 只能拿到分数 -9 的石子堆，输掉比赛。
     * 如果 Alice 拿走前两堆，那么她的得分为 3，接下来 Bob 拿走第三堆，得分为 3 。之后 Alice 只能拿到分数 -9 的石子堆，同样会输掉比赛。
     * 注意，他们都应该采取 最优策略 ，所以在这里 Alice 将选择能够使她获胜的方案。
     * 示例 3：
     *
     * 输入：values = [1,2,3,6]
     * 输出："Tie"
     * 解释：Alice 无法赢得比赛。如果她决定选择前三堆，她可以以平局结束比赛，否则她就会输。
     * 示例 4：
     *
     * 输入：values = [1,2,3,-1,-2,-3,7]
     * 输出："Alice"
     * 示例 5：
     *
     * 输入：values = [-1,-2,-3]
     * 输出："Tie"
     *
     *
     * 提示：
     *
     * 1 <= values.length <= 50000
     * -1000 <= values[i] <= 1000
     */
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[50003];

        int sum = 0;
        for(int i=n-1;i>=0;i--){
            //由于有负值分数，这里注意一下
            dp[i] = Integer.MIN_VALUE;
            sum += stoneValue[i];
            for (int j = i;j < i + 3; j ++) {
                dp[i] = Math.max(dp[i], sum - dp[j+1]);
            }
        }
        int alice = dp[0];
        int bob = sum - dp[0];
        if (alice == bob) return "Tie";
        if (alice > bob) return "Alice";
        return "Bob";
    }

//    public String stoneGameIII(int[] stoneValue) {
//        int a = 0, b = 0;
//        boolean isA = true;
//        int cur = 0;
//        while (cur < stoneValue.length) {
//            int sum = 0;
//            sum += stoneValue[cur];
//            cur ++;
//            if (cur < stoneValue.length &&
//                    (stoneValue[cur] >= 0 && cur + 3 >= stoneValue.length
//                    || cur + 3 < stoneValue.length && stoneValue[cur] >= stoneValue[cur + 3]
//                    || cur + 1 < stoneValue.length && stoneValue[cur] >= stoneValue[cur + 1])) {
//                sum += stoneValue[cur];
//                cur ++;
//            }
//
//            if (cur < stoneValue.length &&
//                    (stoneValue[cur] >= 0 && cur + 3 >= stoneValue.length
//                            || cur + 3 < stoneValue.length && stoneValue[cur] >= stoneValue[cur + 3]
//                            || cur + 1 < stoneValue.length && stoneValue[cur] >= stoneValue[cur + 1])) {
//                sum += stoneValue[cur];
//                cur ++;
//            }
//
//            if (isA) {
//                a += sum;
//            } else {
//                b += sum;
//            }
//
//            isA = !isA;
//        }
//
//        return a > b ? "Alice" : a == b ? "Tie" : "Bob";
//    }



}
