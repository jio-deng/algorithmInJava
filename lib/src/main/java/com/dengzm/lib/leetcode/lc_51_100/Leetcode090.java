package com.dengzm.lib.leetcode.lc_51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 子集 II
 * @date 2020/1/28 17:52
 */
public class Leetcode090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        Arrays.sort(nums);
        subsetsCore(result, new ArrayList<Integer>(), nums, 0);

        return result;
    }

    private void subsetsCore(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        result.add(new ArrayList<>(list));

        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i ++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            subsetsCore(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        if (nums == null || nums.length == 0) {
//            result.add(new ArrayList<Integer>());
//            return result;
//        }
//
//        Arrays.sort(nums);
//        HashMap<String, List<Integer>> map = new HashMap<>();
//        subsetsCore(map, new ArrayList<Integer>(), nums, 0);
//
//        result.addAll(map.values());
//        return result;
//    }
//
//    private void subsetsCore(HashMap<String, List<Integer>> map, List<Integer> list, int[] nums, int index) {
//        String key = getKey(list);
//        if (!map.containsKey(key)) {
//            map.put(key, new ArrayList<>(list));
//        }
//
//        if (index >= nums.length) {
//            return;
//        }
//
//        for (int i = index; i < nums.length; i ++) {
//            if (i > index && nums[i] == nums[i - 1]) {
//                continue;
//            }
//
//            list.add(nums[i]);
//            subsetsCore(map, list, nums, i + 1);
//            list.remove(list.size() - 1);
//        }
//    }
//
//    private String getKey(List<Integer> list) {
//        if (list.size() == 0) {
//            return "";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (Integer i : list) {
//            sb.append(i);
//        }
//
//        return sb.toString();
//    }
}
