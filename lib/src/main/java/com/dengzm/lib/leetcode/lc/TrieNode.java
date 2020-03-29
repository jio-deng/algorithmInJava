package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description TrieNode
 * @date 2020/3/28 11:25
 */
public class TrieNode {
    public char val;
    public boolean isEnd = false;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {}

    public TrieNode(char val) {
        this.val = val;
    }
}
