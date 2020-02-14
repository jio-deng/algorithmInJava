package com.dengzm.lib.leetcode.lc_1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 组合总和
 * @date 2020/1/17 13:51
 */
public class Leetcode039 {
    /**
     * 回溯法
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        combinationSumCore(candidates, target, 0, 0, result, new ArrayList<Integer>());

        return result;
    }

    private void combinationSumCore(int[] candidates, int target, int current, int index, List<List<Integer>> result, List<Integer> list) {
        if (target == current) {
            result.add(list);
            return;
        }

        while (index < candidates.length) {
            if (current + candidates[index] <= target) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(candidates[index]);
                combinationSumCore(candidates, target, current + candidates[index], index ++, result, temp);
            } else {
                return;
            }
        }
    }

    /**---------------------- DP ---------------------**/
    // https://leetcode-cn.com/problems/combination-sum/solution/chao-qiang-gifzhu-ni-shi-yong-dong-tai-gui-hua-qiu/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        //对candidates数组进行排序
        Arrays.sort(candidates);
        int len = candidates.length;

        for (int i = 1; i <= target; i ++) {
            map.put(i, new HashSet<List<Integer>>());

            for (int j = 0; j < len && candidates[j] <= target; j ++) {
                if (i == candidates[j]) {
                    List<Integer> re = new ArrayList<>();
                    re.add(candidates[j]);
                    map.get(i).add(re);
                } else if (i > candidates[j]) {
                    int key = i - candidates[j];

                    if (map.get(key) == null) {
                        continue;
                    }

                    for (Iterator<List<Integer>> iterator = map.get(key).iterator(); iterator.hasNext();) {
                        List<Integer> list = iterator.next();
                        List<Integer> tempList = new ArrayList<>(list);
                        tempList.add(candidates[j]);
                        Collections.sort(tempList); // 这里影响了效率
                        map.get(i).add(tempList);
                    }
                }
            }
        }

        result.addAll(map.get(target));
        return result;
    }
}
