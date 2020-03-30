package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/3/30 9:50
 */
public class LeetcodeComp200329 {
    /**
     * 5368. 找出数组中的幸运数
     * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
     *
     * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
     *
     * 如果数组中存在多个幸运数，只需返回 最大 的那个。
     * 如果数组中不含幸运数，则返回 -1 。
     *  
     *
     * 示例 1：
     *
     * 输入：arr = [2,2,3,4]
     * 输出：2
     * 解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
     * 示例 2：
     *
     * 输入：arr = [1,2,2,3,3,3]
     * 输出：3
     * 解释：1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。
     * 示例 3：
     *
     * 输入：arr = [2,2,2,3,3]
     * 输出：-1
     * 解释：数组中不存在幸运数。
     * 示例 4：
     *
     * 输入：arr = [5]
     * 输出：-1
     * 示例 5：
     *
     * 输入：arr = [7,7,7,7,7,7,7]
     * 输出：7
     *  
     *
     * 提示：
     *
     * 1 <= arr.length <= 500
     * 1 <= arr[i] <= 500
     * 通过次数3,410提交次数4,881
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-lucky-integer-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int findLucky(int[] arr) {
        int[] target = new int[arr.length];
        for (int a : arr) {
            if (a > arr.length) {
                continue;
            }

            target[a-1] ++;
        }

        for (int i = target.length - 1; i >= 0; i --) {
            if (target[i] == i+1) {
                return i+1;
            }
        }

        return -1;
    }

    /**
     * 5369. 统计作战单位数
     * n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
     *
     * 每 3 个士兵可以组成一个作战单位，分组规则如下：
     *
     * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
     * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
     * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：rating = [2,5,3,4,1]
     * 输出：3
     * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
     * 示例 2：
     *
     * 输入：rating = [2,1,3]
     * 输出：0
     * 解释：根据题目条件，我们无法组建作战单位。
     * 示例 3：
     *
     * 输入：rating = [1,2,3,4]
     * 输出：4
     *  
     *
     * 提示：
     *
     * n == rating.length
     * 1 <= n <= 200
     * 1 <= rating[i] <= 10^5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-number-of-teams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numTeams(int[] rating) {
        return findUp(rating, 0, 0, -1) + findDown(rating, 0, 0, 10000000);
    }

    private int findUp(int[] rating, int index, int curNums, int pre) {
        if (curNums == 3) {
            return 1;
        }

        if (index >= rating.length) {
            return 0;
        }

        int ans = 0;
        if (rating[index] > pre) {
            ans += findUp(rating, index + 1, curNums + 1, rating[index]);
        }

        ans += findUp(rating, index + 1, curNums, pre);
        return ans;
    }

    private int findDown(int[] rating, int index, int curNums, int pre) {
        if (curNums == 3) {
            return 1;
        }

        if (index >= rating.length) {
            return 0;
        }

        int ans = 0;
        if (rating[index] < pre) {
            ans += findDown(rating, index + 1, curNums + 1, rating[index]);
        }

        ans += findDown(rating, index + 1, curNums, pre);
        return ans;
    }

    /**
     * 1396. 设计地铁系统
     * 请你实现一个类 UndergroundSystem ，它支持以下 3 种方法：
     *
     * 1. checkIn(int id, string stationName, int t)
     *
     * 编号为 id 的乘客在 t 时刻进入地铁站 stationName 。
     * 一个乘客在同一时间只能在一个地铁站进入或者离开。
     * 2. checkOut(int id, string stationName, int t)
     *
     * 编号为 id 的乘客在 t 时刻离开地铁站 stationName 。
     * 3. getAverageTime(string startStation, string endStation) 
     *
     * 返回从地铁站 startStation 到地铁站 endStation 的平均花费时间。
     * 平均时间计算的行程包括当前为止所有从 startStation 直接到达 endStation 的行程。
     * 调用 getAverageTime 时，询问的路线至少包含一趟行程。
     * 你可以假设所有对 checkIn 和 checkOut 的调用都是符合逻辑的。也就是说，如果一个顾客在 t1 时刻到达某个地铁站，那么他离开的时间 t2 一定满足 t2 > t1 。所有的事件都按时间顺序给出。
     *
     *  
     *
     * 示例：
     *
     * 输入：
     * ["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
     * [[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
     *
     * 输出：
     * [null,null,null,null,null,null,null,14.0,11.0,null,11.0,null,12.0]
     *
     * 解释：
     * UndergroundSystem undergroundSystem = new UndergroundSystem();
     * undergroundSystem.checkIn(45, "Leyton", 3);
     * undergroundSystem.checkIn(32, "Paradise", 8);
     * undergroundSystem.checkIn(27, "Leyton", 10);
     * undergroundSystem.checkOut(45, "Waterloo", 15);
     * undergroundSystem.checkOut(27, "Waterloo", 20);
     * undergroundSystem.checkOut(32, "Cambridge", 22);
     * undergroundSystem.getAverageTime("Paradise", "Cambridge");       // 返回 14.0。从 "Paradise"（时刻 8）到 "Cambridge"(时刻 22)的行程只有一趟
     * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0。总共有 2 躺从 "Leyton" 到 "Waterloo" 的行程，编号为 id=45 的乘客出发于 time=3 到达于 time=15，编号为 id=27 的乘客于 time=10 出发于 time=20 到达。所以平均时间为 ( (15-3) + (20-10) ) / 2 = 11.0
     * undergroundSystem.checkIn(10, "Leyton", 24);
     * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0
     * undergroundSystem.checkOut(10, "Waterloo", 38);
     * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 12.0
     *  
     *
     * 提示：
     *
     * 总共最多有 20000 次操作。
     * 1 <= id, t <= 10^6
     * 所有的字符串包含大写字母，小写字母和数字。
     * 1 <= stationName.length <= 10
     * 与标准答案误差在 10^-5 以内的结果都视为正确结果。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/design-underground-system
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class UndergroundSystem {
        Map<String, Map<Integer, List<Integer>>> checkIn;
        Map<String, Map<Integer, List<Integer>>> checkOut;

        public UndergroundSystem() {
            checkIn = new HashMap<>();
            checkOut = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            if (!checkIn.containsKey(stationName)) {
                checkIn.put(stationName, new HashMap<>());
            }

            if (!checkIn.get(stationName).containsKey(id)) {
                checkIn.get(stationName).put(id, new ArrayList<>());
            }

            checkIn.get(stationName).get(id).add(t);
        }

        public void checkOut(int id, String stationName, int t) {
            if (!checkOut.containsKey(stationName)) {
                checkOut.put(stationName, new HashMap<>());
            }

            if (!checkOut.get(stationName).containsKey(id)) {
                checkOut.get(stationName).put(id, new ArrayList<>());
            }

            checkOut.get(stationName).get(id).add(t);
        }

        public double getAverageTime(String startStation, String endStation) {
            if (!checkIn.containsKey(startStation) || !checkOut.containsKey(endStation)) {
                return -1;
            }

            Map<Integer, List<Integer>> inMap = checkIn.get(startStation);
            Map<Integer, List<Integer>> outMap = checkOut.get(endStation);

            double timeSum = 0, count = 0;
            for (Map.Entry<Integer, List<Integer>> entry : inMap.entrySet()) {
                if (!outMap.containsKey(entry.getKey())) {
                    continue;
                }

                List<Integer> inList = entry.getValue();
                List<Integer> outList = outMap.get(entry.getKey());

                for (int i = 0; i < inList.size(); i ++) {
                    if (i >= outList.size()) {
                        break;
                    }

                    timeSum += outList.get(i) - inList.get(i);
                    count ++;
                }
            }

            return timeSum / count;
        }
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */


    /**
     * 1397. 找到所有好字符串
     * 给你两个长度为 n 的字符串 s1 和 s2 ，以及一个字符串 evil 。请你返回 好字符串 的数目。
     *
     * 好字符串 的定义为：它的长度为 n ，字典序大于等于 s1 ，字典序小于等于 s2 ，且不包含 evil 为子字符串。
     *
     * 由于答案可能很大，请你返回答案对 10^9 + 7 取余的结果。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 2, s1 = "aa", s2 = "da", evil = "b"
     * 输出：51
     * 解释：总共有 25 个以 'a' 开头的好字符串："aa"，"ac"，"ad"，...，"az"。还有 25 个以 'c' 开头的好字符串："ca"，"cc"，"cd"，...，"cz"。最后，还有一个以 'd' 开头的好字符串："da"。
     * 示例 2：
     *
     * 输入：n = 8, s1 = "leetcode", s2 = "leetgoes", evil = "leet"
     * 输出：0
     * 解释：所有字典序大于等于 s1 且小于等于 s2 的字符串都以 evil 字符串 "leet" 开头。所以没有好字符串。
     * 示例 3：
     *
     * 输入：n = 2, s1 = "gx", s2 = "gz", evil = "x"
     * 输出：2
     *  
     *
     * 提示：
     *
     * s1.length == n
     * s2.length == n
     * 1 <= n <= 500
     * 1 <= evil.length <= 50
     * 所有字符串都只包含小写英文字母。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-good-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    // 暴力，超时了
    private static final int MOD = 1000000007;
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        if (s1.compareTo(s2) > 0) {
            return 0;
        }

        int ans = 0;
        String cur = s1;
        while (cur.compareTo(s2) <= 0) {
            int index = cur.lastIndexOf(evil);
            if (index == -1) {
                cur = increase(cur);
                ans ++;
                ans %= MOD;
            } else {
                // System.out.println(cur + " " + index + " " + evil);
                cur = increase(cur, index + evil.length() - 1);
            }
        }

        return ans;
    }

    private String increase(String s) {
        return increase(s, s.length() - 1);
    }

    private String increase(String s, int index) {
        char[] chars = s.toCharArray();
        for (int i = index; i >= 0; i --) {
            if (chars[i] == 'z') {
                chars[i] = 'a';
            } else {
                chars[i] ++;
                break;
            }
        }

        return String.valueOf(chars);
    }


    // TODO 抄了个答案过来，还没看明白
    // https://leetcode-cn.com/problems/find-all-good-strings/solution/shu-wei-dp-kmpqian-zhui-shu-zu-java-by-henrylee4/
    public int findGoodStrings1(int n, String s1, String s2, String evil) {
        int mod = (int) 1e9 + 7;
        int m = evil.length();
        long[][][] dp = new long[n + 1][4][m + 1]; // 第二维度中， 0表示s1和s2都有限制，1表s1有限制， 2表示s2有限制， 3表示s1和s2无限制； 第三维度表示前面已经匹配的evil的长度
        // 初始化
        for (int i = 0; i < m; i++) {
            dp[n][0][i] = 1;
            dp[n][1][i] = 1;
            dp[n][2][i] = 1;
            dp[n][3][i] = 1;
        }
        char[] p = evil.toCharArray();
        int[] prefix = calcuPrefixFunction(p); // O(n)，计算前缀数组
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                // handle 0
                for (char k = s1.charAt(i); k <= s2.charAt(i); k++) {
                    int state = 0;
                    if (k == s1.charAt(i) && k == s2.charAt(i)) {
                        state = 0;
                    } else if (k == s1.charAt(i)) {
                        state = 1;
                    } else if (k == s2.charAt(i)) {
                        state = 2;
                    } else {
                        state = 3;
                    }
                    dp[i][0][j] += dp[i + 1][state][getNext(prefix, p, k, j)];
                    dp[i][0][j] %= mod;
                }
                // handle 1
                for (char k = s1.charAt(i); k <= 'z'; k++) {
                    int state = k == s1.charAt(i) ? 1 : 3;
                    dp[i][1][j] += dp[i + 1][state][getNext(prefix, p, k, j)];
                    dp[i][1][j] %= mod;
                }
                //handle 2
                for (char k = 'a'; k <= s2.charAt(i); k++) {
                    int state = k == s2.charAt(i) ? 2 : 3;
                    dp[i][2][j] += dp[i + 1][state][getNext(prefix, p, k, j)];
                    dp[i][2][j] %= mod;
                }
                // handle 3
                for (char k = 'a'; k <= 'z'; k++) {
                    int state = 3;
                    dp[i][3][j] += dp[i + 1][state][getNext(prefix, p, k, j)];
                    dp[i][3][j] %= mod;
                }
            }
        }
        return (int) dp[0][0][0];
    }

    private int[] calcuPrefixFunction(char[] p) { // 考虑边界情况， 即p的长度为0
        int n = p.length;
        int[] prefixArray = new int[n];  // 表示匹配的长度结果
        prefixArray[0] = 0;
        int j = 0;  // len of match string 表示匹配的长度
        for (int i = 1; i < n; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = prefixArray[j - 1];
            }
            if (p[i] == p[j]) {
                j++;
            }
            prefixArray[i] = j;
        }
        return prefixArray;
    }

    private int getNext(int[] prefix, char[] p, char c, int j) {
        while (j > 0 && c != p[j]) {
            j = prefix[j - 1];
        }
        if (c == p[j]) {
            j++;
        }
        return j;
    }

    

    /**
     *
     */
    public static void main(String[] args) {
        LeetcodeComp200329 leetcodeComp200329 = new LeetcodeComp200329();
        leetcodeComp200329.findLucky(new int[] {7,7,7,7,7,7,7});
    }
}
