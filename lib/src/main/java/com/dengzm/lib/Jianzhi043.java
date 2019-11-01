package com.dengzm.lib;

/**
 * @Description 043 1~n整数中1出现的次数
 *
 * Created by deng on 2019/9/20.
 */
public class Jianzhi043 {

    public static void main(String[] args) {
        System.out.println("Number of 1 in 21345 is " + numberOfOne(21345));
        System.out.println("Number of 1 in 321345 is " + numberOfOne(321345));
        System.out.println("Number of 1 in 221345 is " + numberOfOne(221345));
        System.out.println("Number of 1 in 121345 is " + numberOfOne(121345));
        System.out.println("Number of 1 in 1345 is " + numberOfOne(1345));
        System.out.println("Number of 1 in 3 is " + numberOfOne(3));
    }

    /**
     * 摘抄书中的分析过程，很详细～
     *
     * 举例：21345
     * 先将该数字分成两段，1346～21345和1～1345。
     * 先看前半段，1的出现分为两种情况，10000～19999出现在万位共一万次，该情况是万位为1的数目，所以也要判断万位是否大于1
     * 接下来分析剩下的四位数，每位为1时对应其他0～9，所以1346～21345中四位数中1的个数为2*4*1000=8000次
     * 后半段，1345中1的个数，通过递归去完成即可
     */
    private static int numberOfOne(int target) {
        if (target <= 0) {
            return -1;
        }

        char[] targetChars = Integer.toString(target).toCharArray();
        int first = Integer.valueOf(String.valueOf(targetChars[0]));

        if (targetChars.length == 1) {
            return first == 0 ? 0 : 1;
        }

        int recursive = Integer.valueOf(String.valueOf(targetChars, 1, targetChars.length - 1));

        // 高位，示例中的万位
        int numberFirstDigit = 0;
        if (first > 1) {
            numberFirstDigit = powerBase(targetChars.length - 1);
        } else if (first == 1) {
            numberFirstDigit = recursive;
        }

        // 高位，示例中的后四位
        int numberOtherDigits = first * (targetChars.length - 1) * powerBase(targetChars.length - 2);

        // 低位，递归
        int numberRecursive = numberOfOne(recursive);

        return numberFirstDigit + numberOtherDigits + numberRecursive;
    }


    private static int powerBase(int n) {
        int result = 1;
        if (n > 0) {
            for (int i = 0; i < n; i ++) {
                result *= 10;
            }
        }

        return result;
    }
}
