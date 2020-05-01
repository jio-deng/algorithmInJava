package com.dengzm.lib.leetcode.lc_901_1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 按递增顺序显示卡牌
 * @date 2020/4/30 16:27
 */
public class Leetcode950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        List<Integer> list = new ArrayList<>();
        for (int d : deck) {
            list.add(d);
        }

        list = sort(list);
        int[] ans = new int[list.size()];

        for (int i = 0; i < ans.length; i ++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    private List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < list.size(); i ++) {
            if (i <= (list.size() - 1) / 2) {
                list1.add(list.get(i));
            } else {
                list2.add(list.get(i));
            }
        }

        list2 = sort(list2);
        if (list2.size() > 1 && list1.size() > list2.size()) {
            list2.add(0, list2.remove(list2.size() - 1));
        }

        List<Integer> ans = new ArrayList<>();
        int index = 0;
        while (index < list1.size() && index < list2.size()) {
            ans.add(list1.get(index));
            ans.add(list2.get(index));
            index ++;
        }

        while (index < list1.size()) {
            ans.add(list1.get(index));
            index ++;
        }
        while (index < list2.size()) {
            ans.add(list2.get(index));
            index ++;
        }
        return ans;
    }
}
