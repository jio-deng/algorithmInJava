package com.dengzm.lib.leetcode.lc_301_400;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 回文对
 * @date 2020/8/6 9:57
 */
class Leetcode336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) {
            return res;
        }

        // 生成字典树
        TrieTree trieTree = new TrieTree();
        for (int i = 0; i < words.length; i ++) {
            trieTree.putWord(words[i], i);
        }

        int index;
        // 对每一个单词，从0-words[i].length()-1遍历：
        // 前后进行截取，查找回文位置
        for (int i = 0; i < words.length; i ++) {
            for (int j = 0; j < words[i].length(); j ++) {
                boolean flag = isCircle(words[i], 0, j);
                // 0-j 为 回文
                if (flag) {
                    index = trieTree.findWord(words[i].substring(j+1));
                    if (index != -1 && index != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(index);
                        list.add(i);
                        res.add(list);
                        if (words[index].equals("")) {
                            /*
                             * 输入：
                             * ["a",""]
                             * 预期结果：
                             * [[0,1],[1,0]]
                             */
                            List<Integer> list1 = new ArrayList<>();
                            list1.add(i);
                            list1.add(index);
                            res.add(list1);
                        }
                    }
                }

                flag = isCircle(words[i], j+1, words[i].length() - 1);
                // j+1-end 为 回文
                if (flag) {
                    index = trieTree.findWord(words[i].substring(0, j+1));
                    if (index != -1 && index != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(index);
                        res.add(list);
                    }
                }
            }
        }

        return res;
    }

    /**
     * 判断是否为回文
     */
    public boolean isCircle(String word, int start, int end) {
        if (start >= end) {
            return true;
        }

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }

            start ++;
            end --;
        }

        return true;
    }

    /**
     * 字典树
     */
    static class TrieTree {
        public Node root = new Node('a');

        public void putWord(String word, int index) {
            Node tmp = root;
            for (int i = 0; i < word.length(); i ++) {
                if (tmp.next[word.charAt(i) - 'a'] == null) {
                    tmp.next[word.charAt(i) - 'a'] = new Node(word.charAt(i));
                }

                tmp = tmp.next[word.charAt(i) - 'a'];
            }

            tmp.setEnd(index);
        }

        /**
         * 找到对应反序单词（反着查）
         */
        public int findWord(String word) {
            Node tmp = root;
            for (int i = word.length() - 1; i >= 0; i --) {
                char c = word.charAt(i);
                tmp = tmp.next[c - 'a'];
                if (tmp == null) {
                    return -1;
                }
            }

            return tmp.isEnd ? tmp.index : -1;
        }

        /**
         * node
         * char c         ： 当前字符
         * boolean isEnd  ： 是否为结尾字符
         * Node[] next    ： 后续字符
         * int index      ： 如果为结尾字符，保存对应下标
         */
        static class Node {
            char c;
            boolean isEnd = false;
            Node[] next;
            int index = -1;

            public Node(char c) {
                this.c = c;
                next = new Node[26];
            }

            public void setEnd(int index) {
                isEnd = true;
                this.index = index;
            }
        }
    }
}
