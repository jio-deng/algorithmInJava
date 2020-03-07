package com.dengzm.lib.leetcode.lc_801_900;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 唯一摩尔斯密码词
 * @date 2020/3/6 10:28
 */
public class Leetcode804 {
    private String[] morse = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morse[c-'a']);
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}
