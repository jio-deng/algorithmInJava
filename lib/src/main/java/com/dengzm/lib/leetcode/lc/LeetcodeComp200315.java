package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/3/15 10:05
 */
public class LeetcodeComp200315 {
    /**
     * 1380. 矩阵中的幸运数
     * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
     *
     * 幸运数是指矩阵中满足同时下列两个条件的元素：
     *
     * 在同一行的所有元素中最小
     * 在同一列的所有元素中最大
     *  
     *
     * 示例 1：
     *
     * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
     * 输出：[15]
     * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
     * 示例 2：
     *
     * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
     * 输出：[12]
     * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
     * 示例 3：
     *
     * 输入：matrix = [[7,8],[1,2]]
     * 输出：[7]
     *  
     *
     * 提示：
     *
     * m == mat.length
     * n == mat[i].length
     * 1 <= n, m <= 50
     * 1 <= matrix[i][j] <= 10^5
     * 矩阵中的所有元素都是不同的
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            int min = 100000;
            int index = -1;
            for (int j = 0; j < m; j ++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    index = j;
                }
            }

            boolean flag = true;
            for (int v = 0; v < n; v ++) {
                if (v == i) {
                    continue;
                }

                if (matrix[v][index] > min) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans.add(min);
            }
        }

        return ans;
    }

    /**
     * 1381. 设计一个支持增量操作的栈
     * 请你设计一个支持下述操作的栈。
     *
     * 实现自定义栈类 CustomStack ：
     *
     * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
     * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
     * int pop()：返回栈顶的值，或栈为空时返回 -1 。
     * void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
     *  
     *
     * 示例：
     *
     * 输入：
     * ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
     * [[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
     * 输出：
     * [null,null,null,2,null,null,null,null,null,103,202,201,-1]
     * 解释：
     * CustomStack customStack = new CustomStack(3); // 栈是空的 []
     * customStack.push(1);                          // 栈变为 [1]
     * customStack.push(2);                          // 栈变为 [1, 2]
     * customStack.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
     * customStack.push(2);                          // 栈变为 [1, 2]
     * customStack.push(3);                          // 栈变为 [1, 2, 3]
     * customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
     * customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
     * customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
     * customStack.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
     * customStack.pop();                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
     * customStack.pop();                            // 返回 201 --> 返回栈顶值 201，栈变为 []
     * customStack.pop();                            // 返回 -1 --> 栈为空，返回 -1
     *  
     *
     * 提示：
     *
     * 1 <= maxSize <= 1000
     * 1 <= x <= 1000
     * 1 <= k <= 1000
     * 0 <= val <= 100
     * 每种方法 increment，push 以及 pop 分别最多调用 1000 次
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/design-a-stack-with-increment-operation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class CustomStack {
        private int[] datas;
        private int cur = 0;

        public CustomStack(int maxSize) {
            datas = new int[maxSize];
        }

        public void push(int x) {
            if (cur >= datas.length) {
                return;
            }

            datas[cur] = x;
            cur ++;
        }

        public int pop() {
            if (cur <= 0) {
                return -1;
            }

            cur --;
            return datas[cur];
        }

        public void increment(int k, int val) {
            int right = Math.min(k, cur);
            for (int i = 0; i < right; i ++) {
                datas[i] += val;
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

    /**
     * 1382. 将二叉搜索树变平衡
     * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
     *
     * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
     *
     * 如果有多种构造方法，请你返回任意一种。
     *
     *  
     *
     * 示例：
     *
     *
     *
     * 输入：root = [1,null,2,null,3,null,4,null,null]
     * 输出：[2,1,3,null,null,null,4]
     * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
     *  
     *
     * 提示：
     *
     * 树节点的数目在 1 到 10^4 之间。
     * 树节点的值互不相同，且在 1 到 10^5 之间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/balance-a-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> midList = new ArrayList<>();
        midBST(midList, root);
        return makeTree(midList, 0, midList.size() - 1);
    }

    private void midBST(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        midBST(list, root.left);
        list.add(root.val);
        midBST(list, root.right);
    }

    private TreeNode makeTree(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootIndex = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(rootIndex));
        root.left = makeTree(list, start, rootIndex - 1);
        root.right = makeTree(list, rootIndex + 1, end);

        return root;
    }

    /**
     * 1383. 最大的团队表现值
     * 公司有编号为 1 到 n 的 n 个工程师，给你两个数组 speed 和 efficiency ，其中 speed[i] 和 efficiency[i] 分别代表第 i 位工程师的速度和效率。请你返回由最多 k 个工程师组成的 ​​​​​​最大团队表现值 ，由于答案可能很大，请你返回结果对 10^9 + 7 取余后的结果。
     *
     * 团队表现值 的定义为：一个团队中「所有工程师速度的和」乘以他们「效率值中的最小值」。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
     * 输出：60
     * 解释：
     * 我们选择工程师 2（speed=10 且 efficiency=4）和工程师 5（speed=5 且 efficiency=7）。他们的团队表现值为 performance = (10 + 5) * min(4, 7) = 60 。
     * 示例 2：
     *
     * 输入：n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
     * 输出：68
     * 解释：
     * 此示例与第一个示例相同，除了 k = 3 。我们可以选择工程师 1 ，工程师 2 和工程师 5 得到最大的团队表现值。表现值为 performance = (2 + 10 + 5) * min(5, 4, 7) = 68 。
     * 示例 3：
     *
     * 输入：n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
     * 输出：72
     *  
     *
     * 提示：
     *
     * 1 <= n <= 10^5
     * speed.length == n
     * efficiency.length == n
     * 1 <= speed[i] <= 10^5
     * 1 <= efficiency[i] <= 10^8
     * 1 <= k <= n
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-performance-of-a-team
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Queue<int[]> efficientyMaxQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        Queue<Integer> speedHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i ++) {
            efficientyMaxQueue.add(new int[] {speed[i], efficiency[i]});
        }

        long speeds = 0, res = 0;
        for (int i = 0; i < n; i ++) {
            int[] engineer = efficientyMaxQueue.poll();
            speeds += engineer[0];
            speedHeap.add(engineer[0]);
            speeds -= (i >= k ? speedHeap.poll() : 0);
            res = Math.max(res, speeds * engineer[1]);
        }

        return (int)(res % 1000000007);
    }
}
