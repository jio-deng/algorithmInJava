package com.dengzm.lib.jianzhi;

/**
 * @Description 016 数值的整数次方
 * 实现函数double power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * Created by deng on 2018/12/20.
 */
public class Jianzhi016 {
    public static void main(String[] args) {
        System.out.println(power(0, 20));
        System.out.println(power(1, 20));
        System.out.println(power(1.3, 20));
        System.out.println(power(-1.3, 20));
        System.out.println(power(1.3, 21));
        System.out.println(power(1.3, -21));
    }

    //0的0次幂没有意义，且指数为负的时候无法0无法作为分母求倒数
    public static double power(double base, int exponent) {
        if (base == 0.0 && exponent <= 0) {
            return 0.0;
        }

        int absExponent = exponent < 0 ? - exponent : exponent;
        double absResult = powerCore(base, absExponent);
        return exponent < 0 ? 1.0 / absResult : absResult;
    }

    //优化后的求法：
    //当指数为偶数时，不需要一步步求解，而是复用上一步的操作，例如：32次幂相当于16次幂的平方；
    //当指数为奇数时，例如：31次幂相当于15次幂的平方再乘以base
    //根据上述方法可以写成一个递归的操作
    private static double powerCore(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerCore(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }
}
