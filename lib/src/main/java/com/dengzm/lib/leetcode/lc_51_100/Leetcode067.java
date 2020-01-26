package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二进制求和
 * @date 2020/1/26 10:12
 */
public class Leetcode067 {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }

        if (b == null || b.length() == 0) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int plusUtra = 0;
        int aIndex = aChars.length - 1;
        int bIndex = bChars.length - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            int aTemp = aChars[aIndex] - '0';
            int bTemp = bChars[bIndex] - '0';
            System.out.println(aTemp + " " + bTemp + " " + String.valueOf(aTemp ^ bTemp ^ plusUtra));

            sb.append(aTemp ^ bTemp ^ plusUtra);
            plusUtra = (aTemp + bTemp + plusUtra) / 2;

            aIndex --;
            bIndex --;
        }

        int index = aIndex >= 0 ? aIndex : bIndex;
        char[] chars = aIndex >= 0 ? aChars : bChars;

        while (index >= 0) {
            int temp = chars[index] - '0';

            sb.append(temp ^ plusUtra);
            plusUtra = (temp + plusUtra) / 2;

            index --;
        }

        if (plusUtra > 0) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
