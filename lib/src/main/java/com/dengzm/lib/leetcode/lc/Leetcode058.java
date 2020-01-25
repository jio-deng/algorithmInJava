package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最后一个单词的长度
 * @date 2020/1/25 10:32
 */
public class Leetcode058 {
    public int lengthOfLastWord1(String s) {
        String target = s.trim();
        if (target.length() == 0) {
            return 0;
        }

        int lastLength = 0;
        int curLength = 0;

        for (int i = 0; i < target.length(); i ++) {
            if (target.charAt(i) == ' ') {
                if (curLength != 0) {
                    lastLength = curLength;
                    curLength = 0;
                }
            } else {
                curLength ++;
            }
        }

        return curLength != 0 ? curLength : lastLength;
    }

    public int lengthOfLastWord(String s) {
        String target = s.trim();
        if (target.length() == 0) {
            return 0;
        }

        int curLength = 0;
        for (int i = target.length() - 1; i >= 0; i --) {
            if (target.charAt(i) == ' ') {
                break;
            } else {
                curLength ++;
            }
        }

        return curLength;
    }

    public static void main(String[] args) {
        Leetcode058 leetcode058 = new Leetcode058();
        System.out.println(leetcode058.lengthOfLastWord(" a"));
    }
}
