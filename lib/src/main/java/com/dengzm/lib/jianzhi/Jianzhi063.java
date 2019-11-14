package com.dengzm.lib.jianzhi;

/**
 * @Description 063 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 例如：[9,11,8,5,7,12,16,14]，在价格为5时买入，16时卖出，利润最大为11
 *
 * Created by deng on 2019/11/1.
 */
public class Jianzhi063 {

    public static void main(String[] args) {
        int[] data1 = new int[] {9,11,8,5,7,12,16,14};

        System.out.println("Max profit in data1 is " + maxProfit(data1));
    }

    /**
     * 记录最小值和最大差值，遍历时不断更新最小值和最大差值
     *
     * @param prices prices
     * @return max diff
     */
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int min = prices[0];
        int maxDiff = prices[1] - min;

        for (int i = 2; i < prices.length; i ++) {
            if (prices[i - 1] < min) {
                min = prices[i - 1];
            }

            int currentDiff = prices[i] - min;
            if (currentDiff > maxDiff) {
                maxDiff = currentDiff;
            }
        }

        return maxDiff;
    }
}
