package com.dengzm.lib;

/**
 * @Description 020 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和消暑）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"及"-1E-16"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * Created by deng on 2018/12/21.
 */
public class Jianzhi020 {
    //用来保存当前检索的位置；
    //如果不想增加该变量，也可以将scanInteger传入的第二个参数改为非基本数据类型
    private static int index = 0;

    public static void main(String[] args) {
        System.out.println(isNumeric("+100"));
        System.out.println(isNumeric("5e2"));
        System.out.println(isNumeric("-123"));
        System.out.println(isNumeric("3.1416"));
        System.out.println(isNumeric("-1E-16"));
        System.out.println(isNumeric("+123."));
        System.out.println();
        System.out.println(isNumeric("12e"));
        System.out.println(isNumeric("1a3.14"));
        System.out.println(isNumeric("1.2.3"));
        System.out.println(isNumeric("+-5"));
        System.out.println(isNumeric("12e+5.4"));
    }

    public static boolean isNumeric(String target) {
        index = 0;
        if (target == null || target.length() == 0) {
            return false;
        }
        char[] targetCh = target.toCharArray();

        boolean numeric = scanInteger(targetCh);

        //scan后需要判断index当前值，防止越界
        if (index == targetCh.length) {
            return true;
        }

        //下面用||的原因：
        //1.小数可以没有整数部分，如.123
        //2.小数点后面可以没有数字，如123.
        //3.小数点前后都可以有数字，如123.123
        if (targetCh[index] == '.') {
            index ++;
            numeric = scanUnsignedInteger(targetCh) || numeric;
        }

        //scan后需要判断index当前值，防止越界
        if (index == targetCh.length) {
            return true;
        }

        //下面用&&的原因：
        //1.当e或E前面没有 数字 时，不能表示数字
        //2.当e或E后面没有 整数 时，不能表示数字
        if (targetCh[index] == 'e' || targetCh[index] == 'E') {
            index ++;
            if (index > targetCh.length - 1) {
                return false;
            }
            numeric = scanInteger(targetCh) && numeric;
        }

        //需符合数字的标准且检索至最后（无其他字符或不符合逻辑的字符）
        return numeric && index == targetCh.length;
    }

    //检测 + - 号
    private static boolean scanInteger(char[] target) {
        if (target[index] == '+' || target[index] == '-') {
            index ++;
        }
        return scanUnsignedInteger(target);
    }

    //检测是否包含n个0-9的数字
    private static boolean scanUnsignedInteger(char[] target) {
        int tempIndex = index;
        while (index < target.length && target[index] >= '0' && target[index] <= '9') {
            index ++;
        }
        return index > tempIndex;
    }
}
