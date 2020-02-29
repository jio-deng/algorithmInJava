package com.dengzm.lib.leetcode.lc_101_200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 单词接龙
 * @date 2020/2/27 9:26
 */
public class Leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null ||
                beginWord.length() == 0 ||
                beginWord.length() != endWord.length() ||
                !wordList.contains(endWord)) {
            return 0;
        }

        // init graph
        int[][] graph = new int[wordList.size()][wordList.size()];
        for (int i = 0; i < wordList.size(); i ++) {
            for (int j = i + 1; j < wordList.size(); j ++) {
                graph[i][j] = graph[j][i] = chayige(wordList.get(i), wordList.get(j));
            }
        }

        int endIndex = wordList.indexOf(endWord);
        int res = 2;

        boolean[] isVisited = new boolean[wordList.size()];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < wordList.size(); i ++) {
            if (chayige(beginWord, wordList.get(i)) == 1) {
                queue.add(i);
                isVisited[i] = true;

                if (i == endIndex) {
                    return res;
                }
            }
        }

        while (queue.size() > 0) {
            res ++;
            int size = queue.size();
            while (size -- > 0) {
                int index = queue.poll();
                int[] g = graph[index];
                for (int i = 0; i < g.length; i ++) {
                    if (g[i] == 1 && !isVisited[i]) {
                        queue.add(i);
                        isVisited[i] = true;

                        if (i == endIndex) {
                            return res;
                        }
                    }
                }
            }
        }

        if (isVisited[endIndex]) {
            return res;
        }

        return 0;
    }

    private int chayige(String s1, String s2) {
        int res = 0;
        for (int i = 0; i < s1.length(); i ++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                res ++;
                if (res > 1) {
                    return 0;
                }
            }
        }

        return res;
    }


    /**
     * dfs 剪枝有问题，待解决
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (beginWord == null || endWord == null ||
//                beginWord.length() == 0 ||
//                beginWord.length() != endWord.length() ||
//                !wordList.contains(endWord)) {
//            return 0;
//        }
//
//        // init graph
//        int[][] graph = new int[wordList.size()][wordList.size()];
//        for (int i = 0; i < wordList.size(); i ++) {
//            for (int j = 0; j < wordList.size(); j ++) {
//                if (i == j) {
//                    continue;
//                }
//
//                graph[i][j] = graph[j][i] = chayige(wordList.get(i), wordList.get(j));
//            }
//        }
//
//        int endIndex = wordList.indexOf(endWord);
//        int res = 100000;
//
//        boolean[] isVisited = new boolean[wordList.size()];
//        int[] memo = new int[wordList.size()];
//
//        for (int i = 0; i < wordList.size(); i ++) {
//            if (chayige(beginWord, wordList.get(i)) == 1) {
//                isVisited[i] = true;
//                res = Math.min(res, ladderLengthCore(graph, i, endIndex, 2, isVisited, memo));
//                isVisited[i] = false;
//            }
//        }
//
//        return res == 100000 ? 0 : res;
//    }
//
//    private int ladderLengthCore(int[][] graph, int curIndex, int endIndex, int steps, boolean[] isVisited, int[] memo) {
//        if (curIndex == endIndex) {
//            return steps;
//        }
//
//        if (memo[curIndex] != 0 && memo[curIndex] < 90000) {
//            return memo[curIndex] + steps;
//        }
//
//        int res = 100000;
//
//        int[] g = graph[curIndex];
//
//        // 剪枝
//        if (g[endIndex] == 1) {
//            memo[curIndex] = 1;
//            return steps + 1;
//        }
//
//        for (int i = 0; i < g.length; i ++) {
//            if (g[i] == 1 && !isVisited[i]) {
//                isVisited[i] = true;
//                res = Math.min(res, ladderLengthCore(graph, i, endIndex, steps + 1, isVisited, memo));
//                isVisited[i] = false;
//            }
//        }
//
//        memo[curIndex] = Math.min(res - steps, memo[curIndex]);
//
//        return res;
//    }
//
//    private int chayige(String s1, String s2) {
//        int res = 0;
//        for (int i = 0; i < s1.length(); i ++) {
//            if (s1.charAt(i) != s2.charAt(i)) {
//                res ++;
//                if (res > 1) {
//                    return 0;
//                }
//            }
//        }
//
//        return res;
//    }
}
