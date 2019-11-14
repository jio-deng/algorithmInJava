package com.dengzm.lib.jianzhi;

/**
 * @Description 005 替换空格
 * 请实现一个函数，把字符串中的每个空格替换成%20
 * Created by deng on 2018/12/19.
 */
public class Jianzhi005 {

    public static void main(String[] args) {
        String target = "We are happy !";
        System.out.println(replaceSpace(target));

    }

    //首先遍历字符串，找到空格的数量；则新的字符串的数量为当前字符串的长度加上两倍的空格数量
    //再次遍历字符串，生成新的字符串
    public static String replaceSpace(String target) {
        if (target == null || target.length() == 0) {
            return "Error : target string is empty!";
        }

        int count = 0;
        char[] targetString = target.toCharArray();
        for (char c : targetString) {
            if (c == ' ') {
                count ++;
            }
        }

        if (count == 0) {
            return target;
        }

        char[] resultString = new char[targetString.length + count * 2];
        int resultCount = 0;
        for (int i = 0; i < targetString.length; i ++) {
            if (targetString[i] != ' ') {
                resultString[resultCount] = targetString[i];
                resultCount ++;
            } else {
                resultString[resultCount] = '%';
                resultString[resultCount + 1] = '2';
                resultString[resultCount + 2] = '0';
                resultCount += 3;
            }
        }

        return String.valueOf(resultString);
    }
}
