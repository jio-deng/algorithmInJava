package com.dengzm.lib.leetcode.lc_101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 单词接龙 II
 * @date 2020/2/28 12:15
 */
public class Leetcode126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }

        Set<String> dist = new HashSet<>(wordList);
        Set<String> isVisited = new HashSet<>();
        LinkedList<List<String>> queue= new LinkedList<>();
        queue.add(Arrays.asList(beginWord));
        isVisited.add(beginWord);
        boolean flag = false;

        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            Set<String> subSet = new HashSet<>();

            while (size > 0) {
                List<String> list = queue.poll();
                String preWord = list.get(list.size() - 1);
                char[] chars = preWord.toCharArray();

                // 寻找该单词的下一个符合条件的单词
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        if (temp == ch) {
                            continue;
                        }
                        String w = new String(chars);

                        if (dist.contains(w) && !isVisited.contains(w)) {
                            List<String> newList = new ArrayList<>(list);
                            newList.add(w);

                            if (w.equals(endWord)) {
                                res.add(newList);
                                flag = true;
                            }

                            queue.add(newList);
                            subSet.add(w);
                        }


                    }
                    chars[j] = temp;
                }

                size --;
            }

            isVisited.addAll(subSet);
        }

        return res;
    }















//    /**
//     * timeout
//     */
//    private String endWord;
//    private List<String> wordList;
//    private boolean[] isUsed;
//    private int min = 1000000;
//
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        this.endWord = endWord;
//        this.wordList = wordList;
//        isUsed = new boolean[wordList.size()];
//        for (int i = 0; i < wordList.size(); i ++) {
//            if (wordList.get(i).equals(beginWord)) {
//                isUsed[i] = true;
//                break;
//            }
//        }
//
//        List<List<String>> ans = new ArrayList<>();
//        List<String> list = new ArrayList<>();
//        list.add(beginWord);
//        findLaddersCore(beginWord, ans, list);
//        return ans;
//    }
//
//    private void findLaddersCore(String word, List<List<String>> ans, List<String> list) {
//        if (list.size() > min) {
//            return;
//        }
//
//        if (word.equals(endWord)) {
//            if (list.size() == min) {
//                ans.add(new ArrayList<>(list));
//            } else {
//                min = list.size();
//                ans.clear();
//                ans.add(new ArrayList<>(list));
//            }
//
//            return;
//        }
//
//        for (int i = 0; i < wordList.size(); i ++) {
//            if (isUsed[i]) {
//                continue;
//            }
//
//            if (chayige(word, wordList.get(i))) {
//                isUsed[i] = true;
//                list.add(wordList.get(i));
//                findLaddersCore(wordList.get(i), ans, list);
//                isUsed[i] = false;
//                list.remove(list.size() - 1);
//            }
//        }
//    }
//
//    private boolean chayige(String s1, String s2) {
//        int res = 0;
//        for (int i = 0; i < s1.length(); i ++) {
//            if (s1.charAt(i) != s2.charAt(i)) {
//                res ++;
//                if (res > 1) {
//                    return false;
//                }
//            }
//        }
//
//        return res == 1;
//    }
}
