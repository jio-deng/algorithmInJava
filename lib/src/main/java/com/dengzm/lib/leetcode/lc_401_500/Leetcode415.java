package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 字符串相加
 * @date 2020/2/17 11:02
 */
public class Leetcode415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i>=0) carry += num1.charAt(i--)-'0';
            if(j>=0) carry += num2.charAt(j--)-'0';
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public String addStrings1(String num1, String num2) {
        String longer = num1.length() > num2.length() ? num1 : num2;
        String shorter = num1.length() > num2.length() ? num2 : num1;

        longer = new StringBuilder(longer).reverse().toString();
        shorter = new StringBuilder(shorter).reverse().toString();

        StringBuilder result = new StringBuilder();
        int extra = 0;
        int index = 0;
        while (index < shorter.length()) {
            int tmp = longer.charAt(index) - '0' + shorter.charAt(index) - '0' + extra;
            extra = tmp / 10;
            tmp %= 10;
            result.insert(0, tmp);
            index ++;
        }

        while (index < longer.length()) {
            int tmp = longer.charAt(index) - '0' + extra;
            extra = tmp / 10;
            tmp %= 10;
            result.insert(0, tmp);
            index ++;
        }

        if (extra != 0) {
            result.insert(0, extra);
        }

        return result.toString();
    }
}
