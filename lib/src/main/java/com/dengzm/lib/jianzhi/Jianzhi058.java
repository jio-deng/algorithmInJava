package com.dengzm.lib.jianzhi;

/**
 * @Description 058 翻转字符串
 * 题目一：翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，标点和普通字符一样处理
 * 例如：I am a student.  ->  student. a am I
 * 题目二：左旋转字符串
 * 把字符串前面的若干字符转移到字符串的尾部
 *
 * Created by deng on 2019/10/31.
 */
public class Jianzhi058 {

    public static void main(String[] args) {
        String s1 = "I am a student.";
        String s2 = " I am a student. ";
        String s3 = "asdfghjkl";

        System.out.println(reverseSentence(s1));
        System.out.println(reverseSentence(s2));
        System.out.println(leftRotateString(s3, 0));
        System.out.println(leftRotateString(s3, 1));
        System.out.println(leftRotateString(s3, 5));
        System.out.println(leftRotateString(s3, 9));
    }

    /**
     * 题目一
     * 先将整个句子翻转，再将每个单词翻转
     *
     * @param target target
     * @return reversed target
     */
    private static String reverseSentence(String target) {
        if (target == null || target.length() == 0) {
            return "";
        }

        char[] targetChars = target.toCharArray();
        // 整体翻转
        reverse(targetChars, 0, targetChars.length - 1);

        int start = 0;
        int end = 0;

        // 单词翻转，判断条件为，空格分隔的为单词
        while (start < targetChars.length - 1) {
            while (targetChars[end] != ' ') {
                end ++;
            }

            reverse(targetChars, start, end - 1);

            end ++;
            start = end;
        }

        return String.valueOf(targetChars);
    }

    /**
     * 题目二
     * 与题目一类似，利用n分段后，各自翻转，最后整体翻转即可
     *
     * @param target target
     * @param n left rotate num
     * @return left rotated target
     */
    private static String leftRotateString(String target, int n) {
        if (target == null || target.length() == 0 || n < 0 || n > target.length()) {
            return "";
        }

        char[] targetChars = target.toCharArray();

        int firstStart = 0;
        int firstEnd = n - 1;
        int secondStart = n;
        int secondEnd = targetChars.length - 1;

        // 各自翻转
        reverse(targetChars, firstStart, firstEnd);
        reverse(targetChars, secondStart, secondEnd);

        // 整体翻转
        reverse(targetChars, 0, targetChars.length - 1);

        return String.valueOf(targetChars);
    }

    /**
     * reverse
     *
     * @param target target
     * @param start start
     * @param end end
     */
    private static void reverse(char[] target, int start, int end) {
        if (target == null || target.length == 0 || start >= end || end >= target.length) {
            return;
        }

        while (start < end) {
            char temp = target[start];
            target[start] = target[end];
            target[end] = temp;

            start ++;
            end --;
        }
    }
}
