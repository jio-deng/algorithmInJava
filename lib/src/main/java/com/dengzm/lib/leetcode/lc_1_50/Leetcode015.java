package com.dengzm.lib.leetcode.lc_1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 三数之和
 * @date 2019/12/16 18:39
 */
public class Leetcode015 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums == null || nums.length < 3) {
            return ans;
        }

        int len = nums.length;
        Arrays.sort(nums); // 排序

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue; // 去重
            }
            int L = i+1;
            int R = len-1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }

    /*执行结果：通过
      显示详情
      执行用时 :33 ms, 在所有 java 提交中击败了94.25%的用户
      内存消耗 :47.9 MB, 在所有 java 提交中击败了93.57%的用户*/




    // 自己写的 超时了。。姑且放在这吧
    @Deprecated
    public List<List<Integer>> threeSumNotWorking(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i ++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 1; j ++) {
                int tValue = nums[i] + nums[j];
                if (tValue > 0) {
                    break;
                }

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int s = j + 1;

                boolean flag = false;
                while (s < nums.length) {
                    if (s > j + 1 && nums[s] == nums[s - 1]) {
                        s ++;
                        continue;
                    }
                    int sum = tValue + nums[s];
                    if (sum > 0) {
                        break;
                    } else if (sum == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[s]);
                        result.add(list);

                        s ++;
                    } else {
                        s ++;
                    }
                }
            }
        }

        return result;
    }
}
