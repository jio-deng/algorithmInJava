package com.dengzm.lib.leetcode.lc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 双周赛第15场
 * @date 2019/12/23 9:26
 */
public class LeetcodeComp15 {
    /**
     * 1287.有序数组中出现次数超过25%的元素
     * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
     *
     * 请你找到并返回这个整数
     *
     *  
     *
     * 示例：
     *
     * 输入：arr = [1,2,2,6,6,6,6,7,10]
     * 输出：6
     *  
     *
     * 提示：
     *
     * 1 <= arr.length <= 10^4
     * 0 <= arr[i] <= 10^5
     */
    public int findSpecialInteger(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("wtf");
        }

        if (arr.length < 4) {
            return arr[0];
        }

        int span = arr.length / 4 + 1;
//        System.out.println("span = " + span);

        for (int i = 0; i < arr.length; i += span) {
            int target = arr[i];
            int lowerLoc = findLower(arr, target, 0, arr.length - 1);
            int higherLoc = findHigher(arr, target, 0, arr.length - 1);
//            System.out.println("i = " + i);
//            System.out.println("low = " + lowerLoc);
//            System.out.println("high = " + higherLoc);

            if (higherLoc - lowerLoc + 1 >= span) {
                return target;
            }
        }

        throw new RuntimeException("wtf");
    }

    private int findLower(int[] arr, int target, int left, int right) {
        if (left == right) {
            return left;
        }

        int mid = (left + right) / 2;

        if (arr[mid] > target) {
            return findLower(arr, target, left, mid - 1);
        } else if (arr[mid] < target) {
            return findLower(arr, target, mid + 1, right);
        } else {
            if (mid == 0 || arr[mid - 1] < target) {
                return mid;
            } else if (mid - 1 <= left) {
                return left;
            } else {
                return findLower(arr, target, left, mid - 1);
            }
        }
    }

    private int findHigher(int[] arr, int target, int left, int right) {
        if (left == right) {
            return left;
        }

        int mid = (left + right) / 2;

        if (arr[mid] > target) {
            return findHigher(arr, target, left, mid - 1);
        } else if (arr[mid] < target) {
            return findHigher(arr, target, mid + 1, right);
        } else {
            if (mid == arr.length - 1 || arr[mid + 1] > target) {
                return mid;
            } else if (mid + 1 >= right) {
                return right;
            } else {
                return findHigher(arr, target, mid + 1, right);
            }
        }
    }

    /*执行结果：通过
      显示详情
      执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
      内存消耗 :40.2 MB, 在所有 java 提交中击败了100.00%的用户*/


    /**
     * 1288. 删除被覆盖区间
     * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
     *
     * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
     *
     * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
     *
     *  
     *
     * 示例：
     *
     * 输入：intervals = [[1,4],[3,6],[2,8]]
     * 输出：2
     * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
     *  
     *
     * 提示：​​​​​​
     *
     * 1 <= intervals.length <= 1000
     * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
     * 对于所有的 i != j：intervals[i] != intervals[j]
     */
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        int result = intervals.length;
        int rMax = intervals[0][0] - 1;
        for (int i = 0; i < intervals.length; i ++) {
            if (intervals[i][1] <= rMax) {
                result --;
            } else {
                rMax = intervals[i][1];
            }
        }

        return result;
    }



    public static void main(String[] args) {
        LeetcodeComp15 code = new LeetcodeComp15();
        int[] data = new int[] {1,2,3,3};
        System.out.println(code.findSpecialInteger(data));
    }
}
