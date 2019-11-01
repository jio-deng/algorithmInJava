package com.dengzm.lib;

/**
 * @Description 038 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * Created by deng on 2019/5/25.
 */
public class Jianzhi038 {

    public static void main(String[] args) {
        String target = "abcdefg";
        printAll(target);
    }

    private static void printAll(String target) {
        if (target == null || target.length() == 0) {
            return;
        }

        if (target.length() == 1) {
            System.out.println(target);
            return;
        }

        char[] targetChar = target.toCharArray();
        printAllCore(targetChar);
    }

    private static void printAllCore(char[] target) {
        for (int i = 0; i < target.length - 1; i ++) {
            for (int j = i + 1; j < target.length; j ++) {
                switchData(target, i, j);
                System.out.println(String.valueOf(target));
                switchData(target, i, j);
            }
        }
    }

    private static void switchData(char[] target, int i, int j) {
        char temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }
}
