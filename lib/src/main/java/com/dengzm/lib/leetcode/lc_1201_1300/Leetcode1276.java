package com.dengzm.lib.leetcode.lc_1201_1300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 不浪费原料的汉堡制作方案
 * @date 2020/4/17 19:03
 */
public class Leetcode1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>();

        int left = tomatoSlices - 2 * cheeseSlices;
        if (left >= 0 && left % 2 == 0 && left / 2 <= cheeseSlices) {
            ans.add(left / 2);
            ans.add(cheeseSlices - left / 2);
        }

        return ans;
    }
}
