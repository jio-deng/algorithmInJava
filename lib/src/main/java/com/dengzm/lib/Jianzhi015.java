package com.dengzm.lib;

/**
 * @Description 015 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * Created by deng on 2018/12/20.
 */
public class Jianzhi015 {
    public static void main(String[] args) {
        System.out.println(numberOf1_1(100));
        System.out.println(numberOf1_1(-100));
        System.out.println(numberOf1_2(100));
        System.out.println(numberOf1_2(-100));
        System.out.println(Integer.toBinaryString(-100));
    }

    //解法1：考虑到有负数的情况，如果对原数字进行右移，会在高位产生1；故使用flag=1并左移，共进行32次循环
    public static int numberOf1_1(int num) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((num & flag) != 0) {
                count ++;
            }
            flag = flag << 1;
        }
        return count;
    }

    //解法2：低位为1时，减1变为0；低位为0时，减1使得最近的一个为1的高位变为0，此位以下的低位均变为1。
    //此时进行&操作，可以消去原数中的一个1
    public static int numberOf1_2(int num) {
        int count = 0;
        while (num != 0) {
            count ++;
            num = num & (num - 1);
        }
        return count;
    }
}
