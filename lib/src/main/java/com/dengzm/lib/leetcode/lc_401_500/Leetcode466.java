package com.dengzm.lib.leetcode.lc_401_500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 统计重复个数
 * @date 2020/4/19 9:42
 */
public class Leetcode466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0 || n2 == 0 || s1 == null || s2 == null) {
            return 0;
        }

        int s1cnt = 0, index = 0, s2cnt = 0;

        /**
         * recall 是我们用来找循环节的变量，它是一个哈希映射
         * 我们如何找循环节？假设我们遍历了 s1cnt 个 s1，此时匹配到了第 s2cnt 个 s2 中的第 index 个字符
         * 如果我们之前遍历了 s1cnt' 个 s1 时，匹配到的是第 s2cnt' 个 s2 中同样的第 index 个字符，那么就有循环节了
         * 我们用 (s1cnt', s2cnt', index) 和 (s1cnt, s2cnt, index) 表示两次包含相同 index 的匹配结果
         * 那么哈希映射中的键就是 index，值就是 (s1cnt', s2cnt') 这个二元组
         * 循环节就是；
         *    - 前 s1cnt' 个 s1 包含了 s2cnt' 个 s2
         *    - 以后的每 (s1cnt - s1cnt') 个 s1 包含了 (s2cnt - s2cnt') 个 s2
         * 那么还会剩下 (n1 - s1cnt') % (s1cnt - s1cnt') 个 s1, 我们对这些与 s2 进行暴力匹配
         * 注意 s2 要从第 index 个字符开始匹配
         */
        Map<Integer, Count> recall = new HashMap<>();
        Count pre, in;

        while (true) {
            // 我们多遍历一个 s1，看看能不能找到循环节
            s1cnt ++;
            for (char c : s1.toCharArray()) {
                if (c == s2.charAt(index)) {
                    index ++;
                    if (index == s2.length()) {
                        s2cnt ++;
                        index = 0;
                    }
                }
            }

            // 还没有找到循环节，所有的 s1 就用完了
            if (s1cnt == n1) {
                return s2cnt / n2;
            }

            // 出现了之前的 index，表示找到了循环节
            if (recall.containsKey(index)) {
                // 前 s1cnt' 个 s1 包含了 s2cnt' 个 s2
                pre = recall.get(index);
                // 以后的每 (s1cnt - s1cnt') 个 s1 包含了 (s2cnt - s2cnt') 个 s2
                in = new Count(s1cnt - pre.s1cnt, s2cnt - pre.s2cnt);
                break;
            } else {
                recall.put(index, new Count(s1cnt, s2cnt));
            }

        }

        // ans 存储的是 S1 包含的 s2 的数量，考虑的之前的 pre_loop 和 in_loop
        int ans = pre.s2cnt + (n1 - pre.s1cnt) / in.s1cnt * in.s2cnt;
        // S1 的末尾还剩下一些 s1，我们暴力进行匹配
        int rest = (n1 - pre.s1cnt) % in.s1cnt;
        for (int i = 0; i < rest; i ++) {
            for (char ch : s1.toCharArray()) {
                if (ch == s2.charAt(index)) {
                    index ++;
                    if (index == s2.length()) {
                        index = 0;
                        ans ++;
                    }
                }
            }
        }

        // S1 包含 ans 个 s2，那么就包含 ans / n2 个 S2
        return ans / n2;
    }

    class Count {
        public int s1cnt;
        public int s2cnt;

        public Count(int s1cnt, int s2cnt) {
            this.s1cnt = s1cnt;
            this.s2cnt = s2cnt;
        }
    }


//    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
//        if (s1.length() * n1 < s2.length() * n2) {
//            return 0;
//        }
//
//        int gcd = gcd(n1, n2);
//        n1 /= gcd;
//        n2 /= gcd;
//
//        StringBuilder s = new StringBuilder(s1);
//        int cur = 0;
//        for (int i = 0; i < s2.length(); i ++) {
//            if (cur >= s.length()) {
//                s.append(s1);
//            }
//
//            while (s2.charAt(i) != s.charAt(cur)) {
//                cur ++;
//
//                if (cur >= s.length()) {
//                    s.append(s1);
//                }
//            }
//
//            cur ++;
//        }
//
//        int cur2 = cur;
//        for (int i = 0; i < s2.length(); i ++) {
//            if (cur2 >= s.length()) {
//                s.append(s1);
//            }
//
//            while (s2.charAt(i) != s.charAt(cur2)) {
//                cur2 ++;
//
//                if (cur2 >= s.length()) {
//                    s.append(s1);
//                }
//            }
//
//            cur2 ++;
//        }
//
//        int loopLen = cur2 - cur, startSize = cur - loopLen;
//        int totalSize = s1.length() * n1 - startSize, requireLoopSize = loopLen * n2;
//        System.out.println(
//                "cur = " + cur + ", cur2 = " + cur2 + ", " +
//                "loopLen = " + loopLen + ", startSize = " +
//                startSize + ", totalSize = " + totalSize +
//                ", requireLoopSize = " + requireLoopSize);
//        return totalSize / requireLoopSize;
//    }
//
//    private int gcd(int x, int y) {
//        return x == 0 ? y : gcd(y%x, x);
//    }

    public static void main(String[] args) {
        Leetcode466 leetcode466 = new Leetcode466();
        leetcode466.getMaxRepetitions("ecbafedcba", 4, "abcdef", 1);
    }
}
