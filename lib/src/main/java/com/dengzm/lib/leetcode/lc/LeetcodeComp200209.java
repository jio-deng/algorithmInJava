package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import javafx.collections.transformation.SortedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/2/9 9:37
 */
public class LeetcodeComp200209 {

    /**
     * 5332. 检查整数及其两倍数是否存在
     * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
     *
     * 更正式地，检查是否存在两个下标 i 和 j 满足：
     *
     * i != j
     * 0 <= i, j < arr.length
     * arr[i] == 2 * arr[j]
     *
     *
     * 示例 1：
     *
     * 输入：arr = [10,2,5,3]
     * 输出：true
     * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
     * 示例 2：
     *
     * 输入：arr = [7,1,14,11]
     * 输出：true
     * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
     * 示例 3：
     *
     * 输入：arr = [3,1,7,11]
     * 输出：false
     * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
     *
     *
     * 提示：
     *
     * 2 <= arr.length <= 500
     * -10^3 <= arr[i] <= 10^3
     */
    public boolean checkIfExist(int[] arr) {
        if (arr == null || arr.length < 2) {
            return false;
        }

        Arrays.sort(arr);
        int length = 0;
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] < 0) {
                arr[i] = -arr[i];
                length ++;
            } else {
                break;
            }
        }

        if (length == 0) {
            // 都是正, do nothing
        } else if (length == arr.length) {
            // 都是负
            Arrays.sort(arr);
        } else {
            int[] arr1 = new int[length];
            int[] arr2 = new int[arr.length - length];
            for (int i = 0; i < length; i ++) {
                arr1[i] = arr[i];
            }

            for (int i = length; i < arr.length; i ++) {
                arr2[i-length] = arr[i];
            }

            Arrays.sort(arr1);

            return checkIfExistCore(arr1) || checkIfExistCore(arr2);
        }

        return checkIfExistCore(arr);
    }

    private boolean checkIfExistCore(int[] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            int num = arr[i] * 2;
            if (num > arr[arr.length - 1]) {
                break;
            }

            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[j] == num) {
                    return true;
                } else if (arr[j] > num) {
                    break;
                }
            }
        }

        return false;
    }

    /**
     * 5333. 制造字母异位词的最小步骤数
     * 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
     *
     * 返回使 t 成为 s 的字母异位词的最小步骤数。
     *
     * 字母异位词 指字母相同，但排列不同的字符串。
     *
     *
     *
     * 示例 1：
     *
     * 输出：s = "bab", t = "aba"
     * 输出：1
     * 提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
     * 示例 2：
     *
     * 输出：s = "leetcode", t = "practice"
     * 输出：5
     * 提示：用合适的字符替换 t 中的 'p', 'r', 'a', 'i' 和 'c'，使 t 变成 s 的字母异位词。
     * 示例 3：
     *
     * 输出：s = "anagram", t = "mangaar"
     * 输出：0
     * 提示："anagram" 和 "mangaar" 本身就是一组字母异位词。
     * 示例 4：
     *
     * 输出：s = "xxyyzz", t = "xxyyzz"
     * 输出：0
     * 示例 5：
     *
     * 输出：s = "friend", t = "family"
     * 输出：4
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 50000
     * s.length == t.length
     * s 和 t 只包含小写英文字母
     */
    public int minSteps(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return -1;
        }

        if (s.length() == 0 || s.equals(t)) {
            return 0;
        }

        int result = 0;
        int[] sChars = new int[128];
        int[] tChars = new int[128];

        for (int i = 0; i < s.length(); i ++) {
            sChars[s.charAt(i)] ++;
            tChars[t.charAt(i)] ++;
        }

        for (int i = 0; i < sChars.length; i ++) {
            if (sChars[i] > tChars[i]) {
                result += (sChars[i] - tChars[i]);
            }
        }

        return result;
    }

    /**
     * 5334. 推文计数
     * 请你实现一个能够支持以下两种方法的推文计数类 TweetCounts：
     *
     * 1. recordTweet(string tweetName, int time)
     *
     * 记录推文发布情况：用户 tweetName 在 time（以 秒 为单位）时刻发布了一条推文。
     * 2. getTweetCountsPerFrequency(string freq, string tweetName, int startTime, int endTime)
     *
     * 返回从开始时间 startTime（以 秒 为单位）到结束时间 endTime（以 秒 为单位）内，每 分 minute，时 hour 或者 日 day （取决于 freq）内指定用户 tweetName 发布的推文总数。
     * freq 的值始终为 分 minute，时 hour 或者 日 day 之一，表示获取指定用户 tweetName 发布推文次数的时间间隔。
     * 第一个时间间隔始终从 startTime 开始，因此时间间隔为 [startTime, startTime + delta*1>,  [startTime + delta*1, startTime + delta*2>, [startTime + delta*2, startTime + delta*3>, ... , [startTime + delta*i, min(startTime + delta*(i+1), endTime + 1)>，其中 i 和 delta（取决于 freq）都是非负整数。
     *
     *
     * 示例：
     *
     * 输入：
     * ["TweetCounts","recordTweet","recordTweet","recordTweet","getTweetCountsPerFrequency","getTweetCountsPerFrequency","recordTweet","getTweetCountsPerFrequency"]
     * [[],["tweet3",0],["tweet3",60],["tweet3",10],["minute","tweet3",0,59],["minute","tweet3",0,60],["tweet3",120],["hour","tweet3",0,210]]
     *
     * 输出：
     * [null,null,null,null,[2],[2,1],null,[4]]
     *
     * 解释：
     * TweetCounts tweetCounts = new TweetCounts();
     * tweetCounts.recordTweet("tweet3", 0);
     * tweetCounts.recordTweet("tweet3", 60);
     * tweetCounts.recordTweet("tweet3", 10);                             // "tweet3" 发布推文的时间分别是 0, 10 和 60 。
     * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59); // 返回 [2]。统计频率是每分钟（60 秒），因此只有一个有效时间间隔 [0,60> - > 2 条推文。
     * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // 返回 [2,1]。统计频率是每分钟（60 秒），因此有两个有效时间间隔 1) [0,60> - > 2 条推文，和 2) [60,61> - > 1 条推文。
     * tweetCounts.recordTweet("tweet3", 120);                            // "tweet3" 发布推文的时间分别是 0, 10, 60 和 120 。
     * tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  // 返回 [4]。统计频率是每小时（3600 秒），因此只有一个有效时间间隔 [0,211> - > 4 条推文。
     *
     *
     * 提示：
     *
     * 同时考虑 recordTweet 和 getTweetCountsPerFrequency，最多有 10000 次操作。
     * 0 <= time, startTime, endTime <= 10^9
     * 0 <= endTime - startTime <= 10^4
     */
    /**
     * Your TweetCounts object will be instantiated and called as such:
     * TweetCounts obj = new TweetCounts();
     * obj.recordTweet(tweetName,time);
     * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
     */
    class TweetCounts {
        Map<String, List<Integer>> map = new HashMap<>();

        public TweetCounts() {

        }

        public void recordTweet(String tweetName, int time) {
            if (map.get(tweetName) == null) {
                map.put(tweetName, new ArrayList<Integer>());
            }
            List<Integer> list = map.get(tweetName);
            list.add(time);
            Collections.sort(list);
            map.put(tweetName, list);
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName,
                                                        int startTime, int endTime) {
            List<Integer> results = new ArrayList<>();
            List<Integer> tweets = map.get(tweetName);
            int interval;
            switch (freq) {
                case "minute":
                    interval = 60;
                    break;
                case "hour":
                    interval = 60 * 60;
                    break;
                default:
                    interval = 60 * 60 * 24;
                    break;
            }

            for (int time = startTime; time <= endTime; time += interval) {
                final int begin = time;
                final int end = Math.min(time + interval, endTime + 1);
                long count = tweets.stream().filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer >= begin && integer < end;
                    }
                }).count();
                results.add((int) count);
            }
            return results;
        }
    }
//    class TweetCounts {
//        private static final int GAP_MINUTE = 60;
//        private static final int GAP_HOUR = 3600;
//        private static final int GAP_DAY = 86400;
//
//        HashMap<String, ArrayList<Integer>> map;
//
//        public TweetCounts() {
//            map = new HashMap<>();
//        }
//
//        public void recordTweet(String tweetName, int time) {
//            if (!map.containsKey(tweetName)) {
//                ArrayList<Integer> list = new ArrayList<>();
//                map.put(tweetName, list);
//            }
//
//            map.get(tweetName).add(time);
//
//            // TODO : how to simplify ?
//            Collections.sort(map.get(tweetName), new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o1 - o2;
//                }
//            });
//        }
//
//        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
//            List<Integer> result = new ArrayList<>();
//
//            if (!map.containsKey(tweetName)) {
//                result.add(0);
//                return result;
//            }
//
//            ArrayList<Integer> list = map.get(tweetName);
//            int gap = getGap(freq);
//
//            int num = 0;
//            int end = startTime + gap;
//            int i;
//
//            for (i = 0; i < list.size(); i ++) {
//                if (list.get(i) < startTime) {
//                    continue;
//                }
//
//                if (list.get(i) > endTime) {
//                    result.add(num);
//                    num = 0;
//                    break;
//                }
//
//                while (list.get(i) >= end) {
//                    result.add(num);
//                    num = 0;
//                    end += gap;
//                }
//
//                num ++;
//            }
//
////            while (end < endTime) {
////                result.add(num);
////                num = 0;
////                end += gap;
////            }
//
//            System.out.println(i);
//            if (i == list.size()) {
//                result.add(num);
//
//                while (end < endTime) {
//                    result.add(0);
//                    end += gap;
//                }
//            } else if (result.size() == 0) {
//                result.add(0);
//            }
//
//            return result;
//        }
//
//        private int getGap(String freq) {
//            switch (freq) {
//                case "minute":
//                    return GAP_MINUTE;
//                case "hour":
//                    return GAP_HOUR;
//                case "day":
//                    return GAP_DAY;
//            }
//
//            return GAP_MINUTE;
//        }
//    }


    /**
     * 5335. 参加考试的最大学生数
     * 给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。
     *
     * 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的一起参加考试且无法作弊的最大学生人数。
     *
     * 学生必须坐在状况良好的座位上。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：seats = [["#",".","#","#",".","#"],
     *               [".","#","#","#","#","."],
     *               ["#",".","#","#",".","#"]]
     * 输出：4
     * 解释：教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。
     * 示例 2：
     *
     * 输入：seats = [[".","#"],
     *               ["#","#"],
     *               ["#","."],
     *               ["#","#"],
     *               [".","#"]]
     * 输出：3
     * 解释：让所有学生坐在可用的座位上。
     * 示例 3：
     *
     * 输入：seats = [["#",".",".",".","#"],
     *               [".","#",".","#","."],
     *               [".",".","#",".","."],
     *               [".","#",".","#","."],
     *               ["#",".",".",".","#"]]
     * 输出：10
     * 解释：让学生坐在第 1、3 和 5 列的可用座位上。
     *
     *
     * 提示：
     *
     * seats 只包含字符 '.' 和'#'
     * m == seats.length
     * n == seats[i].length
     * 1 <= m <= 8
     * 1 <= n <= 8
     */
    public int maxStudents(char[][] seats) {
        int row = seats.length, col = seats[0].length;
        int[][] dp = new int[row+1][1<<col];
        for (int i = row-1; i >= 0; i --) {
            for (int preMask = 0; preMask < 1<<col; preMask ++) {
                int res = 0;
                for (int mask = 0; mask < 1<<col; mask ++) {
                    if (isValid(mask, preMask, seats, i)) {
                        res = Math.max(res, Integer.bitCount(mask) + dp[i+1][mask]);
                    }
                }

                dp[i][preMask] = res;
            }
        }

        // TODO : why i dont have to find the max in dp[0] ?
        return dp[0][0];
    }

    private boolean isValid(int mask, int preMask, char[][] seats, int row) {
        int col = seats[0].length;

        for (int i = 0; i < col; i ++) {
            if ((mask & (1 << i)) == 0) {
                continue;
            }

            if (seats[row][i] == '#') {
                return false;
            }

            if (i > 0 && seats[row][i - 1] == '.' && (mask & (1 << (i - 1))) != 0) {
                return false;
            }
            if (i < col - 1 && seats[row][i + 1] == '.' && (mask & (1 << (i + 1))) != 0) {
                return false;
            }
            if (row > 0 && i > 0 && seats[row - 1][i - 1] == '.' && (preMask & (1 << (i - 1))) != 0) {
                return false;
            }
            if (row > 0 && i < col - 1 && seats[row - 1][i + 1] == '.' && (preMask & (1 << (i + 1))) != 0) {
                return false;
            }
        }

        return true;
    }




    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        LeetcodeComp200209 leetcodeComp200209 = new LeetcodeComp200209();
        int[] arr = new int[] {-10,12,-20,-8,15};
        System.out.println(leetcodeComp200209.checkIfExist(arr));
    }
}
