package com.dengzm.lib.leetcode.lc_401_500;

import java.util.ArrayList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 键盘行
 * @date 2020/2/21 13:41
 */
public class Leetcode500 {
    String s1 = "QWERTYUIOPqwertyuiop";
    String s2 = "ASDFGHJKLasdfghjkl";
    String s3 = "ZXCVBNMzxcvbnm";

    public String[] findWords(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        for (String s : words) {
            if (isKeyboardRow(s)) {
                list.add(s);
            }
        }

        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    private boolean isKeyboardRow(String target) {
        String regix = s1.indexOf(target.charAt(0)) >= 0 ? s1 : s2.indexOf(target.charAt(0)) >= 0 ? s2 : s3;
        for (int i = 1; i < target.length(); i ++) {
            if (regix.indexOf(target.charAt(i)) == -1) {
                return false;
            }
        }

        return true;
    }
}
