package com.dengzm.lib.leetcode.lc;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/1/12 10:20
 */
public class LeetcodeComp200112 {

    /**
     * 5307. 将整数转换为两个无零整数的和
     * 「无零整数」是十进制表示中 不含任何 0 的正整数。
     *
     * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
     *
     * A 和 B 都是无零整数
     * A + B = n
     * 题目数据保证至少有一个有效的解决方案。
     *
     * 如果存在多个有效解决方案，你可以返回其中任意一个。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：[1,1]
     * 解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。
     * 示例 2：
     *
     * 输入：n = 11
     * 输出：[2,9]
     * 示例 3：
     *
     * 输入：n = 10000
     * 输出：[1,9999]
     * 示例 4：
     *
     * 输入：n = 69
     * 输出：[1,68]
     * 示例 5：
     *
     * 输入：n = 1010
     * 输出：[11,999]
     *
     *
     * 提示：
     *
     * 2 <= n <= 10^4
     */
    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];

        for (int i = 1; i <= n / 2; i ++) {
            int first = i;
            int second = n - first;

            while (first != 0) {
                int temp = first % 10;
                if (temp == 0) {
                    break;
                }

                first = first / 10;
            }

            if (!hasZero(first) && !hasZero(second)) {
                result[0] = i;
                result[1] = n - i;
                break;
            }
        }

        return result;
    }

    public boolean hasZero(int target) {
        while (target != 0) {
            int temp = target % 10;
            if (temp == 0) {
                break;
            }

            target = target / 10;
        }

        return target != 0;
    }

    /**
     * 5308. 或运算的最小翻转次数
     * 给你三个正整数 a、b 和 c。
     *
     * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
     *
     * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：a = 2, b = 6, c = 5
     * 输出：3
     * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
     * 示例 2：
     *
     * 输入：a = 4, b = 2, c = 7
     * 输出：1
     * 示例 3：
     *
     * 输入：a = 1, b = 2, c = 3
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= a <= 10^9
     * 1 <= b <= 10^9
     * 1 <= c <= 10^9
     */
    public int minFlips(int a, int b, int c) {
        int result = 0;

        while (a != 0 || b != 0 || c != 0) {
            int aTemp = a % 2;
            int bTemp = b % 2;
            int cTemp = c % 2;

            if (cTemp == 0) {
                if (aTemp != 0) {
                    result ++;
                }

                if (bTemp != 0) {
                    result ++;
                }
            } else {
                if (aTemp == 0 && bTemp == 0) {
                    result ++;
                }
            }

            a = a / 2;
            b = b / 2;
            c = c / 2;
        }

        return result;
    }

    /**
     * 5309. 连通网络的操作次数
     * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
     *
     * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
     *
     * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
     * 输出：1
     * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
     * 示例 2：
     *
     *
     *
     * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
     * 输出：2
     * 示例 3：
     *
     * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
     * 输出：-1
     * 解释：线缆数量不足。
     * 示例 4：
     *
     * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= n <= 10^5
     * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
     * connections[i].length == 2
     * 0 <= connections[i][0], connections[i][1] < n
     * connections[i][0] != connections[i][1]
     * 没有重复的连接。
     * 两台计算机不会通过多条线缆连接。
     */

    /**
     * 并查集Union-find及其在最小生成树中的应用
     * https://cloud.tencent.com/developer/article/1065270
     */

    int[] fa = new int[100100];// 父节点
    int[] ra = new int[100100];// 深度

    public void initFa(int n) {
        for (int i = 0; i < n; i ++) {
            fa[i] = i;
            ra[i] = 0;
        }
    }

    public int findFa(int x) {
        //递归路径压缩查找
        if (fa[x] != x) {
            fa[x] = findFa(fa[x]);
        }

        return fa[x];
    }

    public void unite(int x, int y) {
        x = findFa(x);
        y = findFa(y);

        if (x == y) {
            return;
        }

        if (ra[x] > ra[y]) {
            fa[y] = x;
        } else {
            fa[x] = y;
            if (ra[x] == ra[y]) {
                ra[y] ++;
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        initFa(n);

        for (int i = 0; i < connections.length; i ++) {
            int[] line = connections[i];
            unite(line[0], line[1]);
        }

        int cnt = 0;
        for (int i = 0; i < n; i ++) {
            if (findFa(i) == i) {
                cnt ++;
            }
        }

        return cnt - 1;
    }


    /**
     * 5310. 二指输入的的最小距离
     * 二指输入法定制键盘在 XY 平面上的布局如上图所示，其中每个大写英文字母都位于某个坐标处，例如字母 A 位于坐标 (0,0)，字母 B 位于坐标 (0,1)，字母 P 位于坐标 (2,3) 且字母 Z 位于坐标 (4,1)。
     *
     * 给你一个待输入字符串 word，请你计算并返回在仅使用两根手指的情况下，键入该字符串需要的最小移动总距离。坐标 (x1,y1) 和 (x2,y2) 之间的距离是 |x1 - x2| + |y1 - y2|。
     *
     * 注意，两根手指的起始位置是零代价的，不计入移动总距离。你的两根手指的起始位置也不必从首字母或者前两个字母开始。
     *
     *
     *
     * 示例 1：
     *
     * 输入：word = "CAKE"
     * 输出：3
     * 解释：
     * 使用两根手指输入 "CAKE" 的最佳方案之一是：
     * 手指 1 在字母 'C' 上 -> 移动距离 = 0
     * 手指 1 在字母 'A' 上 -> 移动距离 = 从字母 'C' 到字母 'A' 的距离 = 2
     * 手指 2 在字母 'K' 上 -> 移动距离 = 0
     * 手指 2 在字母 'E' 上 -> 移动距离 = 从字母 'K' 到字母 'E' 的距离  = 1
     * 总距离 = 3
     * 示例 2：
     *
     * 输入：word = "HAPPY"
     * 输出：6
     * 解释：
     * 使用两根手指输入 "HAPPY" 的最佳方案之一是：
     * 手指 1 在字母 'H' 上 -> 移动距离 = 0
     * 手指 1 在字母 'A' 上 -> 移动距离 = 从字母 'H' 到字母 'A' 的距离 = 2
     * 手指 2 在字母 'P' 上 -> 移动距离 = 0
     * 手指 2 在字母 'P' 上 -> 移动距离 = 从字母 'P' 到字母 'P' 的距离 = 0
     * 手指 1 在字母 'Y' 上 -> 移动距离 = 从字母 'A' 到字母 'Y' 的距离 = 4
     * 总距离 = 6
     * 示例 3：
     *
     * 输入：word = "NEW"
     * 输出：3
     * 示例 4：
     *
     * 输入：word = "YEAR"
     * 输出：7
     *
     *
     * 提示：
     *
     * 2 <= word.length <= 300
     * 每个 word[i] 都是一个大写英文字母。
     */
    public int[][] pos = new int[][] {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},
            {1,0},{1,1},{1,2},{1,3},{1,4},{1,5},
            {2,0},{2,1},{2,2},{2,3},{2,4},{2,5},
            {3,0},{3,1},{3,2},{3,3},{3,4},{3,5},
            {4,0},{4,1}};

    public int dis(char x, char y) {
        return Math.abs(pos[x - 'A'][0] - pos[y - 'A'][0]) + Math.abs(pos[x - 'A'][1] - pos[y - 'A'][1]);
    }

    public int minimumDistance(String word) {
        int len = word.length();

        int[][] d = new int[len][len];      // DP Array

        for (int i = 1; i < len; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);   // 初始化

            for (int j = 0; j < i-1; j++) {
                // 将原先放在第 i-1 个字母上的手指移到 i 上，此时两根手指分别以第 i, j-1 个字母为终点
                d[i][j] = Math.min(d[i][j], d[i-1][j] + dis(word.charAt(i - 1), word.charAt(i)));
                // 将原先放在第 j 个字母上的手指移到 i 上，此时两根手指分别以第 i, i-1 个字母为终点
                d[i][i-1] = Math.min(d[i][i-1], d[i-1][j] + dis(word.charAt(j), word.charAt(i)));
            }

            // 如果此前仅使用了一根手指，可以将第二根手指放在第 i 个字母上，不消耗步数；可以将消耗理解为 `d[i-1][i-1] + 0`
            d[i][i-1] = Math.min(d[i][i-1], d[i-1][i-1]);
            // 依旧仅使用一根手指
            d[i][i] = d[i-1][i-1] + dis(word.charAt(i - 1), word.charAt(i));
        }

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < len-1; i++)
            ret = Math.min(ret, d[len-1][i]);   // 无需考虑 d[len-1][len-1]，必然不是最优

        return ret;
    }

//    public int minimumDistance(String word) {
//        int n = word.length();
//        int[][][][][] dp = new int[n + 1][5][6][5][6];
//
//        for (int a = 0; a < n + 1; a ++) {
//            for (int i = 0; i < 5; i ++) {
//                for (int j = 0; j < 5; j ++) {
//                    for (int ii = 0; ii < 5; ii ++) {
//                        for (int jj = 0; jj < 5; jj ++) {
//                            dp[a][i][j][ii][jj] = 10000;
//                        }
//                    }
//                }
//            }
//        }
//
//        for (int i = 1; i <= n; i ++) {
//            char c = word.charAt(i - 1);
//
//            // 当前字母的坐标
//            int x = pos[c - 'A'][0];
//            int y = pos[c - 'A'][1];
//
//            for (int ii = 0; ii < 5; ii ++) {
//                for (int jj = 0; jj < 5; jj ++) {
//                    dp[i][x][y][ii][jj] = Math.min(dp[i][x][y][ii][jj], dp[i][ii][jj][x][y]);
//                    for (int px = 0; px < 5; px ++) {
//                        for (int py = 0; py < 5; py ++) {
//                            dp[i][x][y][ii][jj] = Math.min(dp[i][x][y][ii][jj], dp[i - 1][ii][jj][px][py] + dis(ii, jj, x, y));
//                            dp[i][x][y][ii][jj] = Math.min(dp[i][x][y][ii][jj], dp[i - 1][px][py][ii][jj] + dis(ii, jj, x, y));
//                        }
//                    }
//
//                    dp[i][x][y][ii][jj] = dp[i][ii][jj][x][y] = Math.min(dp[i][x][y][ii][jj], dp[i][ii][jj][x][y]);
//                }
//            }
//        }
//
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < 5; i ++) {
//            for (int j = 0; j < 5; j ++) {
//                for (int ii = 0; ii < 5; ii ++) {
//                    for (int jj = 0; jj < 5; jj ++) {
//                        ans = Math.min(ans, dp[n][i][j][ii][jj]);
//                    }
//                }
//            }
//        }
//
//        return ans;
//    }


    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        LeetcodeComp200112 leetcodeComp200112 = new LeetcodeComp200112();
        leetcodeComp200112.minFlips(8, 3, 5);

        int n = 10;
        int[][] connections = new int[][] {{2,8},{1,6},{6,7},{7,9},{0,6},{0,2},{1,8},{2,6},{6,9},{1,3},{0,4}};
        System.out.println(leetcodeComp200112.makeConnected(n, connections));
    }
}
