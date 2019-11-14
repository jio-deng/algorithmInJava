package com.dengzm.lib.jianzhi;

/**
 * @Description 065 不用加减乘除做加法
 * 写一个函数，求两个正数之和，不得使用加减乘除四则运算符
 *
 * Created by deng on 2019/11/1.
 */
public class Jianzhi065 {

    public static void main(String[] args) {
        System.out.println("15 + 21 = " + add(15, 21));
    }

    /**
     * 二进制加法
     * 1.首先进行各位上的加，但不考虑进位，获得的结果与"异或"一致
     * 2.然后计算进位，当同一位上都为1时进位，即"与"操作，并将结果左移一位以实现进位
     * 3.重复上述操作，直到无进位数据
     *
     * @param num1 num1
     * @param num2 num2
     * @return sum
     */
    private static int add(int num1, int num2) {
        int sum, carry; // 相加的和（不包含进位）、进位
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        } while (num2 != 0);

        return num1;
    }
}
