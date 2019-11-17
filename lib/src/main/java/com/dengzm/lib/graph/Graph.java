package com.dengzm.lib.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @description 图的算法
 * 最小生成树：普利姆算法、克鲁斯卡尔算法
 * 最短路径：迪杰拉斯算法、弗洛伊德算法、SPFA算法
 * 拓扑排序
 *
 * @author Johnny Deng
 * @date 2019/11/14 11:12
 * @version 1.0
 */
public class Graph {
    public static final int MAX = Integer.MAX_VALUE;

    public int[][] adjacencyMatrix;
    public ArrayList<Edge> edges;

    public Graph() {
    }

    /**
     * 普利姆算法:创建最小生成树
     * 主要思路就是从候选节点中选择最小的权值添加到最小生成树中
     * 详细图文分析见：https://www.cnblogs.com/ludashi/p/5944970.html
     *
     * @return 最小生成树的根节点
     */
    public TreeNode prim() {
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0) {
            return null;
        }

        // 最小生成树的根节点
        TreeNode result = new TreeNode(0, -1, 0);

        int length = adjacencyMatrix.length;

        // 最小权值
        TreeNode[] lowestCost = new TreeNode[length];

        // 标志顶点是否被转正移除
        boolean[] isNodeRemoved = new boolean[length];
        isNodeRemoved[0] = true;

        // 最小值，最小值下标
        TreeNode min;
        int minId;

        // 权值总和
        // int sum = 0;

        // 将邻接矩阵的第一行赋值给最小值，进行初始化
        for (int i = 0; i < length; i ++) {
            if (adjacencyMatrix[0][i] > 0) {
                lowestCost[i] = new TreeNode(i, 0, adjacencyMatrix[0][i]);
            }
        }

        for (int i = 1; i < length; i ++) {
            // reset
            min = new TreeNode(-1, -1, MAX);
            minId = 0;

            for (int j = 0; j < length; j ++) {
                // 找到当前最小权值数组中最小的一个
                if (lowestCost[j] != null && lowestCost[j].value > 0 && lowestCost[j].value < min.value) {
                    min = lowestCost[j];
                    minId = j;
                }
            }

            // 记录权值总和
            // sum += min.value;

            // System.out.println("find a min : " + min.value + ", minId : " + minId);
            // System.out.println("current sum is " + sum);

            // 将该顶点转正并移除
            lowestCost[minId] = null;
            isNodeRemoved[minId] = true;

            result.addChild(min);

            // 更新最小权值表
            for (int j = 0; j < length; j ++) {
                if (!isNodeRemoved[j] && adjacencyMatrix[minId][j] > 0) { // 该顶点没被转正移除 且 数据大于0
                    if (lowestCost[j] == null || adjacencyMatrix[minId][j] < lowestCost[j].value) { // 该顶点之前没有最小权值 或 新转正顶点到该点的权值更小
                        lowestCost[j] = new TreeNode(j, minId, adjacencyMatrix[minId][j]);
                    }
                }
            }
        }

        return result;
    }

    /**
     * 克鲁斯卡尔算法
     * 先将每条边按着权值从小到大进行排序，然后从有序的集合中以此取出最小的边添加到最小生成树中，不过要保证新添加的边与最小生成树上的边不构成回路
     * 详细图文分析见：https://www.cnblogs.com/ludashi/p/5944970.html
     *
     * @return 最小生成树的根节点
     */
    public ArrayList<Edge> kruskal() {
        if (edges == null || edges.size() == 0) {
            return null;
        }

        // 将每条边按着权值从小到大进行排序
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        // 最小生成树的根节点
        ArrayList<Edge> result = new ArrayList<>();

        int length = edges.size();
        // int sum = 0;

        // 路径：核心功能，标记了当前顶点所直接到达的下个顶点
        int[] path = new int[length];

        for (int i = 0; i < length; i ++) {
            Edge edge = edges.get(i);
            int firstEnd = find(path, edge.begin);
            int secondEnd = find(path, edge.end);

            if (firstEnd != secondEnd) {
                path[firstEnd] = secondEnd;
                result.add(edge);
                // sum += edge.weight;
                // System.out.println("Edge : begin " + edge.begin + " end " + edge.end + " is good to go");
                // System.out.println("current sum is " + sum);
            } else {
                // System.out.println("Edge : begin " + edge.begin + " end " + edge.end + " makes a circle, abandon");
            }
        }

        return result;
    }

    /**
     * 通过递归来寻找：index顶点对应的最后一个顶点
     *
     * @param path next of all nodes
     * @param index index
     * @return last node for index
     */
    private int find(int[] path, int index) {
        while (path[index] > 0) {
            index = path[index];
        }
        return index;
    }

    /**
     * 迪杰斯特拉算法
     * Dijkstra算法使用了广度优先搜索解决赋权有向图或者无向图的单源最短路径问题，算法最终得到一个最短路径树。
     * 该算法常用于路由算法或者作为其他图算法的一个子模块。
     * 详细图文分析见：https://blog.csdn.net/qq_35644234/article/details/60870719
     *
     * @return 最短路径数组
     */
    public int[] dijkstra() {
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0) {
            return null;
        }

        int length = adjacencyMatrix.length;

        // 最短路径
        int[] shortestPath = new int[length];

        // 顶点是否确认
        boolean[] isNodeRemoved = new boolean[length];
        isNodeRemoved[0] = true;

        System.arraycopy(adjacencyMatrix[0], 0, shortestPath, 0, length);

        int min, minId;

        for (int i = 0; i < length; i ++) {
            min = MAX;
            minId = -1;

            // 找到当前最短路径中，未被确认的最短路径
            for (int j = 0; j < length; j ++) {
                if (!isNodeRemoved[j] && shortestPath[j] != 0 && shortestPath[j] < min) {
                    min = shortestPath[j];
                    minId = j;
                }
            }

            // 未找到，则所有点已经循环完毕，返回
            if (minId == -1) {
                return shortestPath;
            }

            // 遍历该点到其他点的距离，加上该点到起始点的最短距离，如果小于当前最短路径，则更新
            for (int j = 0; j < length; j ++) {
                if (!isNodeRemoved[j] && adjacencyMatrix[minId][j] != 0 &&
                        (shortestPath[j] == 0 || shortestPath[minId] + adjacencyMatrix[minId][j] < shortestPath[j])) {
                    shortestPath[j] = shortestPath[minId] + adjacencyMatrix[minId][j];
                }
            }

            // 将该点转正
            isNodeRemoved[minId] = true;
        }

        return shortestPath;
    }


    /**
     * Floyd算法
     *
     * 详细图文分析见：
     * 1.https://www.cnblogs.com/wangyuliang/p/9216365.html
     * 2.https://blog.csdn.net/qq_35644234/article/details/60875818
     */
    public int[][] floyd() {
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0) {
            return null;
        }

        int length = adjacencyMatrix.length;

        // 最短距离
        int[][] distance = new int[length][length];

        // 最短距离所经过的点
        // int[][] path = new int[length][length];

        // 行、列、当前起始顶点、当前值(判断当前值是否为无穷大)
        int row, col, vertex, select;

        // init data
        for (row = 0; row < length; row ++) {
            for (col = 0; col < length; col ++) {
                distance[row][col] = adjacencyMatrix[row][col];
                // path[row][col] = col;
            }
        }

        /**
         * 核心代码：三层循环
         * 假如现在只允许经过1号顶点，求任意两点之间的最短路程，应该如何求呢？
         * 只需判断e[i][1]+e[1][j]是否比e[i][j]要小即可,e[i][j]表示的是从i号顶点到j号顶点之间的路程。
         * e[i][1]+e[1][j]表示的是从i号顶点先到1号顶点，再从1号顶点到j号顶点的路程之和。其中i是1~n循环，j也是1~n循环。
         * 遍历所有点，即可以经过任意一点，故套上最外层vertex的循环。
         */
        for (vertex = 0; vertex < length; vertex ++) {
            for (row = 0; row < length; row ++) {
                for (col = 0; col < length; col ++) {
                    if (row == col) {
                        continue;
                    }
                    select = (distance[row][vertex] == 0 || distance[vertex][col] == 0) ? 0 : distance[row][vertex] + distance[vertex][col];
                    if (select > 0 && (distance[row][col] == 0 || select < distance[row][col])) {
                        distance[row][col] = select;
                        // path[row][col] = path[row][vertex];
                    }
                }
            }
        }

        return distance;
    }

    /**
     * SPFA算法
     * 用数组dis记录每个结点的最短路径估计值，用邻接表或邻接矩阵来存储图G。
     * 采取的方法是动态逼近法：设立一个先进先出的队列用来保存待优化的结点，优化时每次取出队首结点u，
     * 并且用u点当前的最短路径估计值对离开u点所指向的结点v进行松弛操作，如果v点的最短路径估计值有所调整，
     * 且v点不在当前的队列中，就将v点放入队尾。这样不断从队列中取出结点来进行松弛操作，直至队列空为止
     *
     * 详细图文分析见：https://blog.csdn.net/qq_35644234/article/details/61614581
     */
    public int[] spfa() {
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0) {
            return null;
        }

        int length = adjacencyMatrix.length;

        // 最短路径
        int[] shortestPath = new int[length];

        System.arraycopy(adjacencyMatrix[0], 0, shortestPath, 0, length);

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i ++) {
            if (shortestPath[i] > 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.pop();

            // 遍历该点到其他点的距离，加上该点到起始点的最短距离，如果小于当前最短路径，则更新
            for (int i = 0; i < length; i ++) {
                if (adjacencyMatrix[vertex][i] != 0 && // 下一行的（i != 0），添加的原因为，我的测试数据默认0为最大值了，为了不让第一个0被加到计算中，所以添加了这个条件
                        ((shortestPath[i] == 0 && i != 0) || shortestPath[vertex] + adjacencyMatrix[vertex][i] < shortestPath[i])) {
                    shortestPath[i] = shortestPath[vertex] + adjacencyMatrix[vertex][i];

                    // 松弛后，如果该点不在队列，则加入队列
                    if (!queue.contains(i)) {
                        queue.add(i);
                    }
                }
            }
        }

        return shortestPath;
    }

    /**
     * 拓扑排序
     *
     * 详细图文分析见：https://blog.csdn.net/qq_41713256/article/details/80805338
     */
    public ArrayList<Integer> topologicalSorting() {
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();

        int length = adjacencyMatrix.length;

        int[] inDegree = new int[length];

        LinkedList<Integer> queue = new LinkedList<>();

        // init in degree of every vertex
        for (int col = 0; col < length; col ++) {
            int in = 0;
            for (int row = 0; row < length; row ++) {
                if (adjacencyMatrix[row][col] > 0) {
                    in ++;
                }
            }

            inDegree[col] = in;

            if (in == 0) {
                queue.add(col);
                // System.out.println("queue add " + col);
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.pop();
            // System.out.println("queue pop " + vertex);
            result.add(vertex);

            for (int col = 0; col < length; col ++) {
                if (vertex != col && adjacencyMatrix[vertex][col] > 0) {
                    inDegree[col] --;

                    if (inDegree[col] == 0) {
                        queue.add(col);
                        // System.out.println("queue add " + col);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // data for prim
        int[][] data = new int[9][9];
        data[0] = new int[]{ 0,10,0,0,0,11,0,0,0 };
        data[1] = new int[]{ 10,0,18,0,0,0,16,0,12 };
        data[2] = new int[]{ 0,0,0,22,0,0,0,0,8 };
        data[3] = new int[]{ 0,0,22,0,20,0,0,16,21 };
        data[4] = new int[]{ 0,0,0,20,0,26,0,7,0 };
        data[5] = new int[]{ 11,0,0,0,26,0,17,0,0 };
        data[6] = new int[]{ 0,16,0,0,0,17,0,19,0 };
        data[7] = new int[]{ 0,0,0,16,7,0,19,0,0 };
        data[8] = new int[]{ 0,12,8,21,0,0,0,0,0 };

        // data for kruskal
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 2, 18));
        edges.add(new Edge(6, 7, 19));
        edges.add(new Edge(3, 4, 20));
        edges.add(new Edge(3, 8, 21));
        edges.add(new Edge(2, 3, 22));
        edges.add(new Edge(3, 6, 24));
        edges.add(new Edge(4, 5, 26));
        edges.add(new Edge(4, 7, 7));
        edges.add(new Edge(2, 8, 8));
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 5, 11));
        edges.add(new Edge(1, 8, 12));
        edges.add(new Edge(3, 7, 16));
        edges.add(new Edge(1, 6, 16));
        edges.add(new Edge(5, 6, 17));

        // data for topological sorting
        int[][] data2 = new int[6][6];
        data2[0] = new int[]{ 0,0,1,0,0,0 };
        data2[1] = new int[]{ 0,0,1,0,0,0 };
        data2[2] = new int[]{ 0,0,0,0,0,1 };
        data2[3] = new int[]{ 0,0,0,0,1,0 };
        data2[4] = new int[]{ 0,0,0,0,0,1 };
        data2[5] = new int[]{ 0,0,0,0,0,0 };

        // init
        Graph graph = new Graph();
        graph.adjacencyMatrix = data;
        graph.edges = edges;

        //————————————————————————————————————

        // 普利姆算法
        System.out.println("————  Prim  ————");
        TreeNode primRoot = graph.prim();
        primRoot.printTree();
        System.out.println("————————————");
        System.out.println();

        // 克鲁斯卡尔算法
        System.out.println("————  Kruskal  ————");
        ArrayList<Edge> kruskalRoot = graph.kruskal();
        for (Edge edge : kruskalRoot) {
            System.out.println("Edge : begin " + edge.begin + " end " + edge.end + " , weight is " + edge.weight);
        }
        System.out.println("————————————");
        System.out.println();

        // 迪杰拉斯算法
        System.out.println("————  Dijkstra  ————");
        int[] dijkstraRoot = graph.dijkstra();
        for (int value : dijkstraRoot) {
            System.out.println(value + " ");
        }
        System.out.println("————————————");
        System.out.println();

        //弗洛伊德算法
        System.out.println("————  Floyd  ————");
        int[][] floyd = graph.floyd();
        for (int row = 0; row < floyd.length; row ++) {
            for (int col = 0; col < floyd.length; col ++) {
                System.out.print(floyd[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("————————————");
        System.out.println();

        //SPFA算法
        System.out.println("————  SPFA  ————");
        int[] spfa = graph.spfa();
        for (int value : spfa) {
            System.out.println(value + " ");
        }
        System.out.println("————————————");
        System.out.println();

        // 拓扑排序
        graph.adjacencyMatrix = data2;
        System.out.println("————  Topological Sorting  ————");
        ArrayList<Integer> topologicalSorting = graph.topologicalSorting();
        for (int value : topologicalSorting) {
            System.out.println(value + " ");
        }
        System.out.println("————————————");
        System.out.println();
    }
}

