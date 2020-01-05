package com.dengzm.lib.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/1/5 10:30
 */
public class LeetcodeComp200105 {

    /**
     * 5303. 解码字母到整数映射
     * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为小写英文字符：
     *
     * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
     * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
     * 返回映射之后形成的新字符串。
     *
     * 题目数据保证映射始终唯一。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "10#11#12"
     * 输出："jkab"
     * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
     * 示例 2：
     *
     * 输入：s = "1326#"
     * 输出："acz"
     * 示例 3：
     *
     * 输入：s = "25#"
     * 输出："y"
     * 示例 4：
     *
     * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
     * 输出："abcdefghijklmnopqrstuvwxyz"
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
     * s 是映射始终存在的有效字符串。
     */
    public String freqAlphabets(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i --) {
            if (s.charAt(i) == '#') {
                sb.append(map.get(s.substring(i - 2, i + 1)));
                i -= 2;
            } else {
                sb.append(map.get(String.valueOf(s.charAt(i))));
            }
        }

        return sb.reverse().toString();
    }

    public HashMap<String, String> map = new HashMap<>();
    {
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10#", "j");
        map.put("11#", "k");
        map.put("12#", "l");
        map.put("13#", "m");
        map.put("14#", "n");
        map.put("15#", "o");
        map.put("16#", "p");
        map.put("17#", "q");
        map.put("18#", "r");
        map.put("19#", "s");
        map.put("20#", "t");
        map.put("21#", "u");
        map.put("22#", "v");
        map.put("23#", "w");
        map.put("24#", "x");
        map.put("25#", "y");
        map.put("26#", "z");
    }


    /**
     * 5304. 子数组异或查询
     * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
     *
     * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
     *
     * 并返回一个包含给定查询 queries 所有结果的数组。
     *
     *
     *
     * 示例 1：
     *
     * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
     * 输出：[2,7,14,8]
     * 解释：
     * 数组中元素的二进制表示形式是：
     * 1 = 0001
     * 3 = 0011
     * 4 = 0100
     * 8 = 1000
     * 查询的 XOR 值为：
     * [0,1] = 1 xor 3 = 2
     * [1,2] = 3 xor 4 = 7
     * [0,3] = 1 xor 3 xor 4 xor 8 = 14
     * [3,3] = 8
     * 示例 2：
     *
     * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
     * 输出：[8,0,4,4]
     *
     *
     * 提示：
     *
     * 1 <= arr.length <= 3 * 10^4
     * 1 <= arr[i] <= 10^9
     * 1 <= queries.length <= 3 * 10^4
     * queries[i].length == 2
     * 0 <= queries[i][0] <= queries[i][1] < arr.length
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] target = new int[queries.length];

        int[][] save = new int[queries.length][2];
        for (int i = 0; i < queries.length; i ++) {
            save[i][0] = queries[i][0];
            save[i][1] = queries[i][1];
        }

        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        for (int i = 0; i < queries.length; i ++) {
            int j;
            if (i == 0 || queries[i][0] != queries[i - 1][0]) {
                j = queries[i][0];
                for (; j <= queries[i][1]; j ++) {
                    target[i] = target[i] ^ arr[j];
                }
            } else {
                if (queries[i][1] == queries[i - 1][1]) {
                    target[i] = target[i - 1];
                } else {
                    j = queries[i - 1][1] + 1;
                    target[i] = target[i - 1];
                    for (; j <= queries[i][1]; j ++) {
                        target[i] = target[i] ^ arr[j];
                    }
                }
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < target.length; i ++) {
            for (int j = 0; j < target.length; j ++) {
                if (save[i][0] == queries[j][0] && save[i][1] == queries[j][1]) {
                    result[i] = target[j];
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 5305. 获取你好友已观看的视频
     * 有 n 个人，每个人都有一个  0 到 n-1 的唯一 id 。
     *
     * 给你数组 watchedVideos  和 friends ，其中 watchedVideos[i]  和 friends[i] 分别表示 id = i 的人观看过的视频列表和他的好友列表。
     *
     * Level 1 的视频包含所有你好友观看过的视频，level 2 的视频包含所有你好友的好友观看过的视频，以此类推。一般的，Level 为 k 的视频包含所有从你出发，最短距离为 k 的好友观看过的视频。
     *
     * 给定你的 id  和一个 level 值，请你找出所有指定 level 的视频，并将它们按观看频率升序返回。如果有频率相同的视频，请将它们按名字字典序从小到大排列。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
     * 输出：["B","C"]
     * 解释：
     * 你的 id 为 0 ，你的朋友包括：
     * id 为 1 -> watchedVideos = ["C"]
     * id 为 2 -> watchedVideos = ["B","C"]
     * 你朋友观看过视频的频率为：
     * B -> 1
     * C -> 2
     * 示例 2：
     *
     *
     *
     * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
     * 输出：["D"]
     * 解释：
     * 你的 id 为 0 ，你朋友的朋友只有一个人，他的 id 为 3 。
     *
     *
     * 提示：
     *
     * n == watchedVideos.length == friends.length
     * 2 <= n <= 100
     * 1 <= watchedVideos[i].length <= 100
     * 1 <= watchedVideos[i][j].length <= 8
     * 0 <= friends[i].length < n
     * 0 <= friends[i][j] < n
     * 0 <= id < n
     * 1 <= level < n
     * 如果 friends[i] 包含 j ，那么 friends[j] 包含 i
     */
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        boolean[] isFriendUsed = new boolean[friends.length];
        isFriendUsed[id] = true;

        LinkedList<Friend> queue = new LinkedList<>();
        int[] myFriend = friends[id];

        int curLevel = 1;
        for (int i = 0; i < myFriend.length; i ++) {
            if (!isFriendUsed[myFriend[i]]) {
                Friend friend = new Friend(curLevel, myFriend[i]);
                queue.add(friend);
                isFriendUsed[myFriend[i]] = true;
            }
        }

        if (level > 1) {
            while (!queue.isEmpty()) {
                if (queue.peek().curLevel >= level) {
                    break;
                }

                Friend friend = queue.poll();
                int cur = friend.curLevel;
                int[] friendsFriend = friends[friend.friendId];
                for (int i = 0; i < friendsFriend.length; i ++) {
                    if (!isFriendUsed[friendsFriend[i]]) {
                        Friend f = new Friend(cur + 1, friendsFriend[i]);
                        queue.add(f);
                        isFriendUsed[friendsFriend[i]] = true;
                    }
                }
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            Friend friend = queue.poll();
            if (friend.curLevel != level) {
                continue;
            }
            List<String> friendVideos = watchedVideos.get(friend.friendId);
            for (String s : friendVideos) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> temp = new ArrayList<>(map.entrySet());
        Collections.sort(temp, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o1.getValue() - o2.getValue();
                }
            }
        });

        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : temp) {
            result.add(entry.getKey());
        }

        return result;
    }

    class Friend {
        public int curLevel;
        public int friendId;

        public Friend(int curLevel, int friendId) {
            this.curLevel = curLevel;
            this.friendId = friendId;
        }
    }


    /**
     * 5306. 让字符串成为回文串的最少插入次数
     * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
     *
     * 请你返回让 s 成为回文串的 最少操作次数 。
     *
     * 「回文串」是正读和反读都相同的字符串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "zzazz"
     * 输出：0
     * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
     * 示例 2：
     *
     * 输入：s = "mbadm"
     * 输出：2
     * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
     * 示例 3：
     *
     * 输入：s = "leetcode"
     * 输出：5
     * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
     * 示例 4：
     *
     * 输入：s = "g"
     * 输出：0
     * 示例 5：
     *
     * 输入：s = "no"
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 500
     * s 中所有字符都是小写字母。
     */
    public int minInsertions(String s) {
        return -1;
    }






    public static void main(String[] args) {
        LeetcodeComp200105 leetcodeComp200105 = new LeetcodeComp200105();

        List<List<String>> watchedVideos = new ArrayList<>();
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("scil");
        a1.add("srdoi");
        a1.add("zb");
        a1.add("atvac");
        a1.add("dzbghzs");
        watchedVideos.add(a1);

        ArrayList<String> a2 = new ArrayList<>();
        a2.add("of");
        a2.add("of");
        watchedVideos.add(a2);

        ArrayList<String> a3 = new ArrayList<>();
        a3.add("riwpk");
        a3.add("gu");
        a3.add("baazjx");
        a3.add("omkmcc");
        a3.add("todigz");
        watchedVideos.add(a3);

        ArrayList<String> a4 = new ArrayList<>();
        a4.add("vlifrgjg");
        a4.add("lcic");
        a4.add("cusukhmj");
        a4.add("k");
        a4.add("kzs");
        watchedVideos.add(a4);

        ArrayList<String> a5 = new ArrayList<>();
        a5.add("drtszt");
        a5.add("hh");
        watchedVideos.add(a5);


        int[][] friends = new int[][] {{2},{3,2}, {0,4,3,1}, {1,2}, {2}};
        int id = 0;
        int level = 2;

        List<String> res = leetcodeComp200105.watchedVideosByFriends(watchedVideos, friends, id, level);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
