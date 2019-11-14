package com.dengzm.lib.jianzhi;

import java.util.Arrays;

/**
 * @Description 066 构建乘积数组
 * 给定一个数组A[0,1,...,n-1]，请构建一个数组B[0,1,...,n-1]，
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]，
 * 不能使用除法！
 *
 * Created by deng on 2019/11/1.
 */
public class Jianzhi066 {

    public static void main(String[] args) {
        int[] data1 = new int[] {1,2,3,4,5,6};
        int[] data2 = new int[6];
        multiply(data1, data2);
        System.out.println(Arrays.toString(data2));
    }

    /**
     * 将B[i]看成两部分，A[0]*A[1]*...*A[i-1]和A[i+1]*...*A[n-1]
     * 定义C[i]=A[0]*A[1]*...*A[i-1],D[i]=A[i+1]*...*A[n-1]，
     * 即C[i]=C[i-1]*A[i-1],D[i]=D[i+1]*A[i+1]
     *
     * @param array1 A[]
     * @param array2 B[]
     */
    private static void multiply(int[] array1, int[] array2) {
        if (array1 == null || array1.length < 2) {
            return;
        }

        array2[0] = 1;

        // C[i]
        for (int i = 1; i < array1.length; i ++) {
            array2[i] = array2[i - 1] * array1[i - 1];
        }

        // D[i]
        double temp = 1;

        for (int i = array1.length - 2; i >= 0; i --) {
            // 计算D[i]
            temp *= array1[i + 1];

            // C[i]*D[i]
            array2[i] *= temp;
        }
    }
}
