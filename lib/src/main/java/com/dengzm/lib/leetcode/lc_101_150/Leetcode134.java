package com.dengzm.lib.leetcode.lc_101_150;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 加油站
 * @date 2020/2/9 9:41
 */
public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int run = 0, rest = 0, start = 0;

        for (int i = 0; i < gas.length; i ++) {
            run += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);

            if (run < 0) {
                start = i + 1;
                run = 0;
            }
        }

        return rest < 0 ? -1 : start;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int result = -1;

        for (int i = gas.length - 1; i >= 0; i --) {
            if (canGoback(gas, cost, i)) {
                result = i;
                break;
            }
        }

        return result;
    }

    private boolean canGoback(int[] gas, int[] cost, int start) {
        int total = gas[start];
        int index, pre = start;
        for (int i = 1; i <= gas.length; i ++) {
            total -= cost[pre];
            if (total < 0) {
                return false;
            }

            index = (start + i) % gas.length;
            if (index != start) {
                total += gas[index];
            }

            pre = index;
        }

        return true;
    }

    public static void main(String[] args) {
        Leetcode134 leetcode134 = new Leetcode134();
        int[] gas = new int[] {6,1,4,3,5};
        int[] cost = new int[] {3,8,2,4,2};

        System.out.println(leetcode134.canCompleteCircuit(gas, cost));
    }
}
