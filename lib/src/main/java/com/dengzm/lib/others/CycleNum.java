package com.dengzm.lib.others;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description     1/3  0.33333  循环节是3
 *                  1/7  0.142857142857  循环节是142857
 *                  输入a b俩数   求循环节
 * @date 2020/3/2 19:59
 */
public class CycleNum {
    public String cycleStep(int a, int b) {
        // 预处理
        if (a == 0 || b == 0 || a % b == 0) {
            return "";
        }

        if (a < 0) {
            a = -a;
        }

        if (b < 0) {
            b = -b;
        }

        return cycleStepCore(a, b);
    }

    private String cycleStepCore(int a, int b) {
        StringBuilder res = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        int left = a % b;

        while (!set.contains(left)) {
            set.add(left);

            while (left < b) {
                left *= 10;
            }

            res.append(left / b);
            left %= b;
        }

        System.out.println(res.toString());
        return res.toString();
    }

    public static void main(String[] args) {
        CycleNum c = new CycleNum();
        c.cycleStep(1, 3);
        c.cycleStep(1, 7);
        c.cycleStep(11, 3);
        c.cycleStep(11, 7);
        c.cycleStep(1111, 97);
        c.cycleStep(11, 197);
    }
}
