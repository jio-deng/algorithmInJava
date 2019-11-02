package com.dengzm.lib;

/**
 * @Description 067 把字符串转换成整数
 *
 * Created by deng on 2019/11/2.
 */
public class Jianzhi067 {
    private static boolean isValid = false;

    public static void main(String[] args) {
        System.out.println(stringToInt("100"));
        System.out.println(isValid);
        System.out.println(stringToInt("+100"));
        System.out.println(isValid);
        System.out.println(stringToInt("++100"));
        System.out.println(isValid);
        System.out.println(stringToInt("-100-"));
        System.out.println(isValid);
        System.out.println(stringToInt("+010"));
        System.out.println(isValid);
        System.out.println(stringToInt("8888888888888888"));
        System.out.println(isValid);
        System.out.println(stringToInt("-8888888888888888"));
        System.out.println(isValid);
        System.out.println(stringToInt("0"));
        System.out.println(isValid);
    }

    private static int stringToInt(String s) {
        isValid = false;

        if (s == null || s.length() == 0) {
            return 0;
        }

        long num = 0;

        int curIndex = 0;

        // 检测首部是否有正负号
        boolean minus = false;
        if (s.charAt(curIndex) == '+') {
            curIndex ++;
        } else if (s.charAt(curIndex) == '-') {
            curIndex ++;
            minus = true;
        }

        while (curIndex < s.length()) {
            // 是否为数字
            if (s.charAt(curIndex) >= '0' && s.charAt(curIndex) <= '9') {

                int flag = minus ? -1 : 1;
                num = num * 10 + flag * (s.charAt(curIndex) - '0');

                // 是否超出int范围
                if ((!minus && num > 0x7FFFFFFF) || (minus && num < 0x80000000)) {
                    num = 0;
                    break;
                }

                curIndex ++;
            } else {
                num = 0;
                break;
            }

            // 正常走完循环，则为正确数字
            if (curIndex == s.length()) {
                isValid = true;
            }
        }

        return (int) num;
    }
}
