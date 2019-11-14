package com.dengzm.lib.jianzhi;

import java.util.HashMap;

/**
 * @Description 050 第一个只出现一次的字符
 *
 * Created by deng on 2019/9/22.
 */
public class Jianzhi050 {

    public static void main(String[] args) {
        String data1 = "asdjbj!)kvbklasdk@%^*&^#&*lvka";
        String data2 = "qwertyuiopasdfghjkqwertyuiopasdfghjkl!";
        String data3 = "qwertyuiopasdfghjkqwertyuiopasdfghjk";

        System.out.println(findFirstNoRepeatChar(data1));
        System.out.println(findFirstNoRepeatChar(data2));
        System.out.println(findFirstNoRepeatChar(data3));
    }

    private static String findFirstNoRepeatChar(String target) {
        if (target == null || target.length() == 0) {
            throw new RuntimeException("sth is wrong with target string");
        }

        char[] targetChars = target.toCharArray();
        HashMap<Character, Integer> repeatNumbers = new HashMap<>();

        for (int i = 0; i < targetChars.length; i ++) {
            if (repeatNumbers.containsKey(targetChars[i])) {
                repeatNumbers.put(targetChars[i], repeatNumbers.get(targetChars[i]) + 1);
            } else {
                repeatNumbers.put(targetChars[i], 1);
            }
        }

        for (int i = 0; i < targetChars.length; i ++) {
            int number = repeatNumbers.get(targetChars[i]);
            if (number == 1) {
                return String.valueOf(targetChars[i]);
            }
        }

        return "there is no NonRepeating char in target string : " + target;
    }
}
