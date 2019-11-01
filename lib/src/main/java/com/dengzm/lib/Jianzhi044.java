package com.dengzm.lib;

/**
 * @Description Created by deng on 2019/9/21.
 */
public class Jianzhi044 {
    public static void main(String[] args) {
        System.out.println("Find digit at " + 5 + " is " + digitAtIndex(5));
        System.out.println("Find digit at " + 55 + " is " + digitAtIndex(55));
        System.out.println("Find digit at " + 555 + " is " + digitAtIndex(555));
        System.out.println("Find digit at " + 5555 + " is " + digitAtIndex(5555));
        System.out.println("Find digit at " + 55555 + " is " + digitAtIndex(55555));
    }

    private static int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }

        int digits = 1;

        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits) {
                return digitAtIndex(index, digits);
            }

            index -= numbers * digits;
            digits ++;
        }
    }

    /**
     * 得到该位数数字的个数
     */
    private static int countOfIntegers(int digits) {
        if (digits == 1) {
            return 10;
        }

        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }

    private static int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i ++) {
            number /= 10;
        }
        return number % 10;
    }

    private static int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }

        return (int) Math.pow(10, digits - 1);
    }
}
