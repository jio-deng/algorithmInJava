package com.dengzm.lib.leetcode.lc_201_300;

import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 添加与搜索单词 - 数据结构设计
 * @date 2020/6/6 9:32
 */
public class Leetcode211 {
    static class WordDictionary {
        TreeNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TreeNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TreeNode node = root;
            for (char c : word.toCharArray()) {
                if (node.nodes[c - 'a'] == null) {
                    node.nodes[c - 'a'] = new TreeNode();
                }

                node = node.nodes[c - 'a'];
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            for (char c : word.toCharArray()) {
                if (queue.isEmpty()) {
                    return false;
                }

                int size = queue.size();
                while (size > 0) {
                    size --;
                    TreeNode node = queue.poll();
                    if (node == null) {
                        continue;
                    }

                    if (c == '.') {
                        for (TreeNode treeNode : node.nodes) {
                            if (treeNode != null) {
                                queue.add(treeNode);
                            }
                        }
                    } else {
                        queue.add(node.nodes[c - 'a']);
                    }
                }
            }

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                if (node.isEnd) {
                    return true;
                }
            }

            return false;
        }

        private class TreeNode {
            boolean isEnd;
            TreeNode[] nodes;

            TreeNode() {
                isEnd = false;
                nodes = new TreeNode[26];
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        boolean param_2 = obj.search("bad");
        boolean param_3 = obj.search("pad");
        boolean param_4 = obj.search("sad");
        boolean param_5 = obj.search("..d");
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
