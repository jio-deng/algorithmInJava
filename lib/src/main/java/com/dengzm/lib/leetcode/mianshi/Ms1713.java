package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 17.13. 恢复空格
 * @date 2020/7/9 9:16
 */
public class Ms1713 {

    public int respace(String[] dictionary, String sentence) {
        // 用字典生成前缀树
        TrieTree trieTree = new TrieTree();
        for (String s : dictionary) {
            trieTree.put(s);
        }

        // dp
        int[] dp = new int[sentence.length() + 1];
        char[] chars = sentence.toCharArray();

        // 从后向前，相当于在句子前一个个加字符
        for (int i = sentence.length() - 1; i >= 0; i --) {
            dp[i] = trieTree.getMin(i, chars, dp);
        }

        return dp[0];
    }

    /**
     * 前缀树的结点
     */
    class Node {
        boolean isEnd = false;
        Node[] next = new Node[26];
    }


    /**
     * 前缀树
     */
    class TrieTree {
        Node root;

        public TrieTree() {
            root = new Node();
        }

        /**
         * 生成树
         * @param word word
         */
        public void put(String word) {
            Node[] n = root.next;
            for (int i = 0; i < word.length(); i ++) {
                char c = word.charAt(i);
                if (n[c-'a'] == null) {
                    n[c-'a'] = new Node();
                }

                if (i == word.length() - 1) {
                    n[c-'a'].isEnd = true;
                }

                n = n[c-'a'].next;
            }
        }

        /**
         * 返回以i开始的最少未识别的字数
         * @param i start
         * @param arr chars
         * @param dp dp
         * @return min
         */
        public int getMin(int i, char[] arr, int[] dp){
            Node cur = root;

            // 若无法找到单词，则返回dp+1
            int ans = dp[i + 1] + 1;
            for(;i < arr.length; i++){
                // 找不到，跳出
                if(cur.next[arr[i] - 'a'] == null){
                    break;
                }

                cur = cur.next[arr[i] - 'a'];

                // 找到一个单词，取min
                if(cur.isEnd){
                    ans = Math.min(ans, dp[i + 1]);
                }
            }
            return ans;

        }
    }
}
