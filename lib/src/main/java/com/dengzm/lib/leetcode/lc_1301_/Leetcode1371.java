package com.dengzm.lib.leetcode.lc_1301_;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 每个元音包含偶数次的最长子字符串
 * @date 2020/5/20 14:54
 */
public class Leetcode1371 {
    // aeiou每个元音用一个bit一共5个bit，32种奇偶次数组合状态，比如10101可以表示aiu出现奇数次数
    // oe则出现偶数次数，每当遍历一个字符，就可以改变当前的aeiou出现的奇偶次数，也即是改变状态
    // 显然，如果两次出现了同样的状态，假设第一次出现在i处
    // 第二次出现在j处，那么i+1-j之间的字符串肯定是满足aeiou出现均为偶数次数的
    // 因为只有经历了偶数个aeiou，才能回到之前的状态，为了使得合理的字符串最长
    // 那么第一次出现此状态时，就需要记录到下标，然后下次遇到相同状态，计算最大长度
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int state = 0;
        int a = 1, e = 1 << 1, i = 1 << 2, o = 1 << 3, u = 1 << 4;
        int ans = 0;
        map.put(0, -1);
        for (int p = 0; p < s.length(); p ++) {
            char c = s.charAt(p);
            if (c == 'a') {
                state ^= a;
            } else if (c == 'e') {
                state ^= e;
            } else if (c == 'i') {
                state ^= i;
            } else if (c == 'o') {
                state ^= o;
            } else if (c == 'u') {
                state ^= u;
            }

            if (!map.containsKey(state)) {
                map.put(state, p);
            }

            ans = Math.max(ans, p - map.get(state));
        }

        return ans;
    }
}
