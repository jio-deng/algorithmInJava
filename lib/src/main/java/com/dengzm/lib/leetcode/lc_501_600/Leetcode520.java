package com.dengzm.lib.leetcode.lc_501_600;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 检测大写字母
 * @date 2020/2/21 15:35
 */
public class Leetcode520 {
    public boolean detectCapitalUse(String word) {
        String shadow = word.toUpperCase();

        boolean isFirstUpper = false;
        boolean isRestUpper = false;
        for (int i = 0; i < word.length(); i ++) {
            if (i == 0) {
                isFirstUpper = word.charAt(i) == shadow.charAt(i);
                continue;
            }

            if (isFirstUpper && i == 1) {
                isRestUpper = word.charAt(i) == shadow.charAt(i);
                continue;
            }

            if (isRestUpper && word.charAt(i) != shadow.charAt(i) || !isRestUpper && word.charAt(i) == shadow.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean detectCapitalUse1(String word) {
        char[] cs = word.toCharArray();
        int upper = 0;//大写字母个数
        int lower = 0;//小写字母个数
        for(int i=0;i<cs.length;i++) {
            if(cs[i]>='a') {
                lower++;
            }else {
                upper++;
            }
        }
        if(upper==cs.length) { //全大写
            return true;
        }
        if(lower==cs.length) {//全小写
            return true;
        }
        if(upper==1 && cs[0]<'a') {//首字母大写
            return true;
        }
        return false;
    }
}
