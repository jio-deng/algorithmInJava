package com.dengzm.lib.jianzhi;

/**
 * @Description 017 打印从1到最大的n位数
 * 输入数字n，按顺序打印从1到最大的n位十进制数。
 * Created by deng on 2018/12/21.
 */
public class Jianzhi017 {
    public static void main(String[] args) {
        print1ToMaxOfDigits(2);
        print1ToMaxOfDigits(3);
    }

    //本题可以看成，打印每位数字0-9的全排列，高位为0的时候0不打印。
    //使用递归的方式，从高位向下递归，当到达位数时，开始打印
    public static void print1ToMaxOfDigits(int n) {
        if (n < 0) {
            return;
        }
        char[] numbers = new char[n];
        for (int i = 0; i < 10; i ++) {
            //0的ASCII码为48
            numbers[0] = (char) (48 + i);
            print1ToMaxOfDigitsRecursively(numbers, 0);
        }
        System.out.println();
    }

    //递归的函数体：判断index为length - 1时，已经递归所有需要的位数，故开始打印。
    private static void print1ToMaxOfDigitsRecursively(char[] numbers, int index) {
        if (index == numbers.length - 1) {
            printNumber(numbers);
            return;
        }

        for (int i = 0; i < 10; i ++) {
            numbers[index + 1] = (char) (48 + i);
            print1ToMaxOfDigitsRecursively(numbers, index + 1);
        }
    }

    //打印函数：高位0不打印；当出现不为0的数字后，打印后续数字
    private static void printNumber(char[] numbers) {
        boolean isBeginning = true;
        StringBuilder sb = new StringBuilder();
        for (char number : numbers) {
            if (isBeginning) {
                if (number != '0') {
                    isBeginning = false;
                }
            }
            if (!isBeginning) {
                sb.append(number);
            }
        }
        String result = sb.toString();
        if (result.length() > 0) {
            System.out.print(result + " ");
        }
    }
}
