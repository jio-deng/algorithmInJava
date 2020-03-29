package com.dengzm.lib.leetcode.lc_201_300;

import com.dengzm.lib.leetcode.lc.TrieNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 实现 Trie (前缀树)
 * @date 2020/3/28 11:31
 */
public class Leetcode208 {
    public static class Trie {

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c-'a'] == null) {
                    node.children[c-'a'] = new TrieNode(c);
                }

                node = node.children[c-'a'];
            }

            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c-'a'] == null) {
                    return false;
                }

                node = node.children[c-'a'];
            }

            return node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return false;
            }

            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] != null) {
                    node = node.children[c - 'a'];
                } else {
                    return false;
                }
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
