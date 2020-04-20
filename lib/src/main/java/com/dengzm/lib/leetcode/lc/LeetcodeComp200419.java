package com.dengzm.lib.leetcode.lc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/4/19 9:40
 */
public class LeetcodeComp200419 {
    /**
     * 5388. 重新格式化字符串 显示英文描述
     * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
     *
     * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
     *
     * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "a0b1c2"
     * 输出："0a1b2c"
     * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
     * 示例 2：
     *
     * 输入：s = "leetcode"
     * 输出：""
     * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
     * 示例 3：
     *
     * 输入：s = "1229857369"
     * 输出：""
     * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
     * 示例 4：
     *
     * 输入：s = "covid2019"
     * 输出："c2o0v1i9d"
     * 示例 5：
     *
     * 输入：s = "ab123"
     * 输出："1a2b3"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 500
     * s 仅由小写英文字母和/或数字组成。
     */
    public String reformat(String s) {
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                list1.add(c);
            } else {
                list2.add(c);
            }
        }

        if (Math.abs(list1.size() - list2.size()) > 1) {
            return "";
        }

        if (list2.size() > list1.size()) {
            List<Character> tmp = list1;
            list1 = list2;
            list2 = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list1.size(); i ++) {
            sb.append(list1.get(i));
            if (i < list2.size()) {
                sb.append(list2.get(i));
            }
        }

        return sb.toString();
    }


    /**
     * 5389. 点菜展示表 显示英文描述
     * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
     *
     * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
     *
     * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
     * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
     * 解释：
     * 点菜展示表如下所示：
     * Table,Beef Burrito,Ceviche,Fried Chicken,Water
     * 3    ,0           ,2      ,1            ,0
     * 5    ,0           ,1      ,0            ,1
     * 10   ,1           ,0      ,0            ,0
     * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
     * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
     * 餐桌 10：Corina 点了 "Beef Burrito"
     * 示例 2：
     *
     * 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
     * 输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
     * 解释：
     * 对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
     * 而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
     * 示例 3：
     *
     * 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
     * 输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
     *
     *
     * 提示：
     *
     * 1 <= orders.length <= 5 * 10^4
     * orders[i].length == 3
     * 1 <= customerNamei.length, foodItemi.length <= 20
     * customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
     * tableNumberi 是 1 到 500 范围内的整数。
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();

        Set<String> allFood = new HashSet<>();
        Map<String, Map<String, Integer>> map = new HashMap<>();

        for (List<String> order : orders) {
            String tId = order.get(1);
            String food = order.get(2);
            allFood.add(food);
            if (!map.containsKey(tId)) {
                map.put(tId, new HashMap<>());
            }

            map.get(tId).put(food, map.get(tId).getOrDefault(food, 0) + 1);
        }

        List<String> titles = new ArrayList<>();
        titles.addAll(allFood);
        Collections.sort(titles, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        titles.add(0, "Table");
        ans.add(titles);

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(entry.getKey());
            Map<String, Integer> subMap = entry.getValue();
            for (int i = 1; i < titles.size(); i ++) {
                String food = titles.get(i);
                list.add(String.valueOf(subMap.getOrDefault(food, 0)));
            }
            ans.add(list);
        }

        Collections.sort(ans, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                if (o1.get(0).equals("Table")) {
                    return -1;
                } else if (o2.get(0).equals("Table")) {
                    return 1;
                } else {
                    return Integer.valueOf(o1.get(0)) - Integer.valueOf(o2.get(0));
                }
            }
        });

        return ans;
    }

    /**
     * 5390. 数青蛙 显示英文描述
     * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
     *
     * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
     *
     * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：croakOfFrogs = "croakcroak"
     * 输出：1
     * 解释：一只青蛙 “呱呱” 两次
     * 示例 2：
     *
     * 输入：croakOfFrogs = "crcoakroak"
     * 输出：2
     * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
     * 第一只青蛙 "crcoakroak"
     * 第二只青蛙 "crcoakroak"
     * 示例 3：
     *
     * 输入：croakOfFrogs = "croakcrook"
     * 输出：-1
     * 解释：给出的字符串不是 "croak" 的有效组合。
     * 示例 4：
     *
     * 输入：croakOfFrogs = "croakcroa"
     * 输出：-1
     *
     *
     * 提示：
     *
     * 1 <= croakOfFrogs.length <= 10^5
     * 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'
     */
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] nums = new int[5];
        int max = 0;
        int cur = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            if (c == 'c') {
                nums[0] ++;
                cur ++;
                max = Math.max(cur, max);
            } else if (c == 'r') {
                if (nums[0] <= nums[1]) {
                    return -1;
                }

                nums[1] ++;
            } else if (c == 'o') {
                if (nums[1] <= nums[2]) {
                    return -1;
                }

                nums[2] ++;
            } else if (c == 'a') {
                if (nums[2] <= nums[3]) {
                    return -1;
                }

                nums[3] ++;
            } else if (c == 'k') {
                if (nums[3] <= nums[4]) {
                    return -1;
                }

                nums[4] ++;
                cur --;
            }
        }

        int all = nums[0];
        for (int i = 1; i < 5; i ++) {
            if (nums[i] != all) {
                return -1;
            }
        }

        return max;
    }

//    public int minNumberOfFrogs(String croakOfFrogs) {
//        if (croakOfFrogs == null || croakOfFrogs.length() < 5) {
//            return -1;
//        }
//
//        int max = 1;
//        int cur = 0;
//        char pre = '.';
//        Deque<Character> stack = new ArrayDeque<>();
//        for (char c : croakOfFrogs.toCharArray()) {
//            if (!judgeChar(c, pre)) {
//                return -1;
//            }
//
//            pre = c;
//            if (c == 'c') {
//                cur ++;
//                max = Math.max(max, cur);
//            }
//
//            if (c != 'k') {
//                stack.push(c);
//            } else {
//                stack.pop();
//                stack.pop();
//                stack.pop();
//                stack.pop();
//                cur --;
//                if (stack.isEmpty()) {
//                    pre = '.';
//                } else {
//                    pre = stack.peek();
//                }
//            }
//        }
//
//        if (!stack.isEmpty()) {
//            return -1;
//        }
//
//        return max;
//    }
//
//    private boolean judgeChar(char c, char pre) {
//        if (c == 'c') {
//            return true;
//        }
//
//        if (c == 'r' && pre == 'c') {
//            return true;
//        }
//
//        if (c == 'o' && pre == 'r') {
//            return true;
//        }
//
//        if (c == 'a' && pre == 'o') {
//            return true;
//        }
//
//        if (c == 'k' && pre == 'a') {
//            return true;
//        }
//
//        return false;
//    }

    /**
     * 5391. 生成数组 显示英文描述
     * 给你三个整数 n、m 和 k 。下图描述的算法用于找出正整数数组中最大的元素。
     *
     *
     *
     * 请你生成一个具有下述属性的数组 arr ：
     *
     * arr 中有 n 个整数。
     * 1 <= arr[i] <= m 其中 (0 <= i < n) 。
     * 将上面提到的算法应用于 arr ，search_cost 的值等于 k 。
     * 返回上述条件下生成数组 arr 的 方法数 ，由于答案可能会很大，所以 必须 对 10^9 + 7 取余。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2, m = 3, k = 1
     * 输出：6
     * 解释：可能的数组分别为 [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
     * 示例 2：
     *
     * 输入：n = 5, m = 2, k = 3
     * 输出：0
     * 解释：没有数组可以满足上述条件
     * 示例 3：
     *
     * 输入：n = 9, m = 1, k = 1
     * 输出：1
     * 解释：可能的数组只有 [1, 1, 1, 1, 1, 1, 1, 1, 1]
     * 示例 4：
     *
     * 输入：n = 50, m = 100, k = 25
     * 输出：34549172
     * 解释：不要忘了对 1000000007 取余
     * 示例 5：
     *
     * 输入：n = 37, m = 17, k = 7
     * 输出：418930126
     *
     *
     * 提示：
     *
     * 1 <= n <= 50
     * 1 <= m <= 100
     * 0 <= k <= n
     */
    private static int mod = (int)1e9 + 7;

    private int n, m, k;

    public int numOfArrays(int n, int m, int k) {
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        long res = 0;
        this.m = m;
        this.n = n;
        this.k = k;
        for(int i = 1; i <= m ; i++){
            res += dfs(dp, 1, i, k - 1);
            res %= mod;
        }
        return (int)res;
    }

    private long dfs(long[][][] dp, int cur, int max, int k){ // 分别表示当前的位置，截至目前最大的元素，剩余的峰值数量
        if(cur == n){
            return k == 0 ? 1: 0; //判断是否符合条件
        }
        if(dp[cur][max][k] != -1){
            return dp[cur][max][k];
        }
        dp[cur][max][k] = dfs(dp, cur + 1, max, k) * max % mod; //可选max个非峰值数
        if(k > 0){
            for(int i = max + 1; i <= m ; i++){  // 依次遍历可选的峰值
                dp[cur][max][k] += dfs(dp, cur + 1, i, k - 1);
                dp[cur][max][k] %= mod;
            }
        }
        return dp[cur][max][k];
    }

//    作者：HenryLee4
//    链接：https://leetcode-cn.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/solution/dong-tai-gui-hua-java-by-henrylee4/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



//    private int MOD = 1000000007;
//    public int numOfArrays(int n, int m, int k) {
//        if (m < k) {
//            return 0;
//        }
//
//        long pick1 = c(m, n);
//        long pick2 = 0;
//        for (int i = 1; i <= Math.min(n-k, k); i ++) {
//            long val = c(m, i);
//            pick2 += val * fill(n-k, i);
//            pick2 %= MOD;
//        }
//
//        return (int) (pick1 * pick2 % MOD);
//    }
//
//    private long c(int m, int n) {
//        long pick = 1;
//        for (int i = 1; i <= n; i ++) {
//            pick *= (m + 1 - i);
//        }
//
//        for (int i = 1; i <= n; i ++) {
//            pick /= i;
//        }
//
//        pick %= MOD;
//        return (int) pick;
//    }
//
//    private long fill(int n, int i) {
//        return fillCore(n, i);
//    }
//
//    private long fillCore(int n, int i) {
//        if (i < 0 || n < 0) {
//            return 0;
//        }
//
//        if (n == 0 || i == 0) {
//            return 1;
//        }
//
//        return fillCore(n - 1, i) + fillCore(n - 1, i - 1);
//    }


    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        LeetcodeComp200419 leetcodeComp200419 = new LeetcodeComp200419();
//        leetcodeComp200419.minNumberOfFrogs("ccroakroak");
        leetcodeComp200419.numOfArrays(2, 3, 1);
    }

}
