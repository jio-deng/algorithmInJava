package com.dengzm.lib.jianzhi;

/**
 * @Description 019 正则表达式匹配
 * 请实现一个函数来匹配包含'.'和'*'的正则表达式。
 * Created by deng on 2018/12/21.
 */
public class Jianzhi019 {
    public static void main(String[] args) {
        System.out.println(match("aaa", "a.a"));
        System.out.println(match("aaa", "ab*ac*a"));
        System.out.println(match("aaa", "aa.a"));
        System.out.println(match("aaa", "ab*a"));
    }

    public static boolean match(String target, String pattern) {
        if (target == null || pattern == null) {
            return false;
        }
        char[] targetCh = target.toCharArray();
        char[] patternCh = pattern.toCharArray();
        return matchCore(targetCh, 0, patternCh, 0);
    }

    private static boolean matchCore(char[] target, int index1, char[] pattern, int index2) {
        //同时检测到末尾，末尾相同则匹配
        if (index1 == target.length - 1 && index2 == pattern.length - 1) {
            return target[index1] == pattern[index2];
        }
        //pattern先检测完，不匹配
        if (index1 != target.length - 1 && index2 == pattern.length - 1) {
            return false;
        }
        //*匹配
        //若当前字母相等，三种情况：
        //1.target和pattern中该段比较，即只有一个进行匹配
        //2.target+1，即多个进行比较，后续比较由递归完成
        //3.不进行匹配，掠过*匹配逻辑
        //若当前字母不想等，与上方（3）相同
        if (pattern[index2 + 1] == '*') {
            if (pattern[index2] == target[index1] || (pattern[index2] == '.' && index1 != target.length - 1)) {
                return matchCore(target, index1 + 1, pattern, index2 + 2)
                        || matchCore(target, index1 + 1, pattern, index2)
                        || matchCore(target, index1, pattern, index2 + 2);
            } else {
                return matchCore(target, index1, pattern, index2 + 2);
            }
        }

        //正常逻辑匹配 + .匹配：向后移动一位
        if (target[index1] == pattern[index2] || (pattern[index2] == '.' && index1 != target.length - 1)) {
            return matchCore(target, index1 + 1, pattern, index2 + 1);
        }

        //若上文无匹配成功，则出现不相同的字母，正则匹配失败
        return false;
    }
}
