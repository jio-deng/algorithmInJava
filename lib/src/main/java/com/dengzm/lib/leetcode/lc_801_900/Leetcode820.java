package com.dengzm.lib.leetcode.lc_801_900;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 单词的压缩编码
 * @date 2020/3/28 10:32
 */
public class Leetcode820 {
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        int ans = 0;
        for (String s : words) {
            if (!trie.insert(s)) {
                ans += s.length() + 1;
            }
        }

        return ans;
    }

    public class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public boolean insert(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }

            TrieNode node = root;
            boolean contains = true;
            for (int i = s.length() - 1; i >= 0; i --) {
                if (node.children[s.charAt(i)-'a'] == null) {
                    node.children[s.charAt(i)-'a'] = new TrieNode(s.charAt(i));
                    contains = false;
                }

                node = node.children[s.charAt(i)-'a'];
            }

            return contains;
        }
    }

    public class TrieNode {
        public char val;
        public boolean isEnd = false;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {}

        public TrieNode(char val) {
            this.val = val;
        }
    }
}
