package com.dengzm.lib.jianzhi;

/**
 * @Description 046 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻译成"b"，···，11翻译成"l"，···，25翻译成"z"
 * 一个数字可能有多种翻译，例如，12258有5种翻译："bccfi"，"bwfi"，"bczi"，"mcfi"，"mzi"
 *
 * Created by deng on 2019/9/21.
 */
public class Jianzhi046 {

    public static void main(String[] args) {
        System.out.println("There are " + getTranslationCount(12258) +  " kinds of translation");
        System.out.println("There are " + getTranslationCount(12258232) +  " kinds of translation");
        System.out.println("There are " + getTranslationCount(1225861111) +  " kinds of translation");
        System.out.println("There are " + getTranslationCount(1225841321) +  " kinds of translation");
    }

    private static int getTranslationCount(int number) {
        if (number < 0) {
            number = 0;
        }

        String numberToString = String.valueOf(number);
        char[] numberToChars = numberToString.toCharArray();
        int[] counts = new int[numberToString.length()];
        int count;

        for (int i = numberToString.length() - 1; i >= 0; i --) {
            if (i < numberToString.length() - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }

            if (i < numberToString.length() - 1) {
                int digit1 = numberToChars[i] - '0';
                int digit2 = numberToChars[i + 1] - '0';

                int converted = digit1 * 10 + digit2;

                if (converted >= 10 && converted <= 25) {
                    if (i < numberToString.length() - 2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }

            counts[i] = count;
        }

        return counts[0];
    }

}
