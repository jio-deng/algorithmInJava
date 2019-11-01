package com.dengzm.lib;

/**
 * @Description 049 丑数
 * 我们把只包含因子2，3和5的数称作丑数。求按从大到小的第1500个丑数
 *
 * Created by deng on 2019/9/22.
 */
public class Jianzhi049 {

    public static void main(String[] args) {
        System.out.println(getUglyNumber(1));
        System.out.println(getUglyNumber(10));
        System.out.println(getUglyNumber(100));
        System.out.println(getUglyNumber(1500));
    }

    private static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyNumberIndex = 1;

        int mutiply2 = 0;
        int mutiply3 = 0;
        int mutiply5 = 0;

        while (nextUglyNumberIndex < index) {
            int num = Math.min(Math.min(uglyNumbers[mutiply2] * 2, uglyNumbers[mutiply3] * 3), uglyNumbers[mutiply5] * 5);
            uglyNumbers[nextUglyNumberIndex] = num;

            while (uglyNumbers[mutiply2] * 2 <= uglyNumbers[nextUglyNumberIndex]) {
                mutiply2 ++;
            }

            while (uglyNumbers[mutiply3] * 3 <= uglyNumbers[nextUglyNumberIndex]) {
                mutiply3 ++;
            }

            while (uglyNumbers[mutiply5] * 5 <= uglyNumbers[nextUglyNumberIndex]) {
                mutiply5 ++;
            }

            nextUglyNumberIndex ++;
        }

        return uglyNumbers[index - 1];

    }
}
