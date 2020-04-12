package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/4/12 10:31
 */
public class LeetcodeComp200412 {
    /**
     * 5380. 数组中的字符串匹配
     * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
     *
     * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：words = ["mass","as","hero","superhero"]
     * 输出：["as","hero"]
     * 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
     * ["hero","as"] 也是有效的答案。
     * 示例 2：
     *
     * 输入：words = ["leetcode","et","code"]
     * 输出：["et","code"]
     * 解释："et" 和 "code" 都是 "leetcode" 的子字符串。
     * 示例 3：
     *
     * 输入：words = ["blue","green","bu"]
     * 输出：[]
     *
     *
     * 提示：
     *
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 30
     * words[i] 仅包含小写英文字母。
     * 题目数据 保证 每个 words[i] 都是独一无二的。
     */
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i ++) {
            for (int j = 0; j < words.length; j ++) {
                if (i == j) {
                    continue;
                }

                if (words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }

        return res;
    }


    /**
     * 5381. 查询带键的排列
     * 给你一个待查数组 queries ，数组中的元素为 1 到 m 之间的正整数。 请你根据以下规则处理所有待查项 queries[i]（从 i=0 到 i=queries.length-1）：
     *
     * 一开始，排列 P=[1,2,3,...,m]。
     * 对于当前的 i ，请你找出待查项 queries[i] 在排列 P 中的位置（下标从 0 开始），然后将其从原位置移动到排列 P 的起始位置（即下标为 0 处）。注意， queries[i] 在 P 中的位置就是 queries[i] 的查询结果。
     * 请你以数组形式返回待查数组  queries 的查询结果。
     *
     *
     *
     * 示例 1：
     *
     * 输入：queries = [3,1,2,1], m = 5
     * 输出：[2,1,2,1]
     * 解释：待查数组 queries 处理如下：
     * 对于 i=0: queries[i]=3, P=[1,2,3,4,5], 3 在 P 中的位置是 2，接着我们把 3 移动到 P 的起始位置，得到 P=[3,1,2,4,5] 。
     * 对于 i=1: queries[i]=1, P=[3,1,2,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,3,2,4,5] 。
     * 对于 i=2: queries[i]=2, P=[1,3,2,4,5], 2 在 P 中的位置是 2，接着我们把 2 移动到 P 的起始位置，得到 P=[2,1,3,4,5] 。
     * 对于 i=3: queries[i]=1, P=[2,1,3,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,2,3,4,5] 。
     * 因此，返回的结果数组为 [2,1,2,1] 。
     * 示例 2：
     *
     * 输入：queries = [4,1,2,2], m = 4
     * 输出：[3,1,2,0]
     * 示例 3：
     *
     * 输入：queries = [7,5,5,8,3], m = 8
     * 输出：[6,5,0,7,5]
     *
     *
     * 提示：
     *
     * 1 <= m <= 10^3
     * 1 <= queries.length <= m
     * 1 <= queries[i] <= m
     */
    public int[] processQueries(int[] queries, int m) {
        int[] ans = new int[queries.length];
        List<Integer> p = new ArrayList<>();
        for (int i = 1; i <= m; i ++) {
            p.add(i);
        }

        int val, pos = 0;
        for (int i = 0; i < queries.length; i ++) {
            val = queries[i];
            for (int j = 0; j < m; j ++) {
                if (p.get(j) == val) {
                    pos = j;
                    break;
                }
            }

            ans[i] = pos;
            p.remove(pos);
            p.add(0, val);
        }

        return ans;
    }

    /**
     * 5382. HTML 实体解析器
     * 「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
     *
     * HTML 里这些特殊字符和它们对应的字符实体包括：
     *
     * 双引号：字符实体为 &quot; ，对应的字符是 " 。
     * 单引号：字符实体为 &apos; ，对应的字符是 ' 。
     * 与符号：字符实体为 &amp; ，对应对的字符是 & 。
     * 大于号：字符实体为 &gt; ，对应的字符是 > 。
     * 小于号：字符实体为 &lt; ，对应的字符是 < 。
     * 斜线号：字符实体为 &frasl; ，对应的字符是 / 。
     * 给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。
     *
     *
     *
     * 示例 1：
     *
     * 输入：text = "&amp; is an HTML entity but &ambassador; is not."
     * 输出："& is an HTML entity but &ambassador; is not."
     * 解释：解析器把字符实体 &amp; 用 & 替换
     * 示例 2：
     *
     * 输入：text = "and I quote: &quot;...&quot;"
     * 输出："and I quote: \"...\""
     * 示例 3：
     *
     * 输入：text = "Stay home! Practice on Leetcode :)"
     * 输出："Stay home! Practice on Leetcode :)"
     * 示例 4：
     *
     * 输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
     * 输出："x > y && x < y is always false"
     * 示例 5：
     *
     * 输入：text = "leetcode.com&frasl;problemset&frasl;all"
     * 输出："leetcode.com/problemset/all"
     *
     *
     * 提示：
     *
     * 1 <= text.length <= 10^5
     * 字符串可能包含 256 个ASCII 字符中的任意字符。
     */
    public String entityParser(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }

        text = text.replaceAll("&frasl;", "/");
        text = text.replaceAll("&lt;", "<");
        text = text.replaceAll("&gt;", ">");
        text = text.replaceAll("&apos;", "'");
        text = text.replaceAll("&quot;", "\"");
        text = text.replaceAll("&amp;", "&");
        return text;
    }

    /**
     * 5383. 给 N x 3 网格图涂色的方案数
     * 你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜色不同）。
     *
     * 给你网格图的行数 n 。
     *
     * 请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 1
     * 输出：12
     * 解释：总共有 12 种可行的方法：
     *
     * 示例 2：
     *
     * 输入：n = 2
     * 输出：54
     * 示例 3：
     *
     * 输入：n = 3
     * 输出：246
     * 示例 4：
     *
     * 输入：n = 7
     * 输出：106494
     * 示例 5：
     *
     * 输入：n = 5000
     * 输出：30228214
     *
     *
     * 提示：
     *
     * n == grid.length
     * grid[i].length == 3
     * 1 <= n <= 5000
     */
    private int MOD = 1000000007;
    private Map<Integer, Long> map2 = new HashMap<>();
    private Map<Integer, Long> map3 = new HashMap<>();

    public int numOfWays(int n) {
        return (int) (3 * (get2(2, 2, n) + get3(2, 2, n)) % MOD);
    }

    private long get2(int val, int cur, int n) {
        if (cur > n) {
            return val;
        }

        if (map2.containsKey(cur)) {
            return val * map2.get(cur) % MOD;
        }

        long v1 = get2(3, cur + 1, n) + get3(2, cur + 1, n);
        map2.put(cur, v1);

        long v = val * v1 % MOD;

        return v;
    }

    private long get3(int val, int cur, int n) {
        if (cur > n) {
            return val;
        }

        if (map3.containsKey(cur)) {
            return val * map3.get(cur) % MOD;
        }

        long v1 = get2(2, cur + 1, n) + get3(2, cur + 1, n);
        map3.put(cur, v1);

        long v = val * v1 % MOD;

        return v;
    }








    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        LeetcodeComp200412 leetcodeComp200412 = new LeetcodeComp200412();
        leetcodeComp200412.processQueries(new int[] {3,1,2,1}, 5);
    }
}
