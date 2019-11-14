package com.dengzm.lib.jianzhi;

/**
 * @Description 064 求1+2+...+n
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字一集条件判断语句
 *
 * Created by deng on 2019/11/1.
 */
public class Jianzhi064 {

    public static void main(String[] args) {
        // 解法一
        Temp.reset();
        System.out.println(Temp.getSum(10));

        // 解法二
        System.out.println(getSum(10));
    }

    /**
     * 解法一：利用构造函数求解
     * 本质上是利用递归来代替循环
     */
    private static class Temp {
        private static int n;
        private static int sum;

        public Temp() {
            sum += ++n;
        }

        public static void reset() {
            n = 0;
            sum = 0;
        }

        public static int getSum() {
            return sum;
        }

        public static int getSum(int num) {
            Temp temp = new Temp();
            return num <= 1 ? getSum() : getSum(num - 1);
        }
    }

    /**
     * 解法二：利用关系运算符
     * 参考网上大神的做法，利用关系运算符代替条件语句
     *
     * @param n num
     * @return sum
     */
    private static int getSum(int n) {
        int sum = n;

        // 当n > 1时，才会进行后面的运算
        // 当n <= 1时，直接返回false
        boolean flag = (n > 1) && (sum += getSum(n - 1)) > 0;

        return sum;
    }


}
