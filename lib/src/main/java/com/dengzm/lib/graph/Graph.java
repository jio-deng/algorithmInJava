package com.dengzm.lib.graph;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @description 图的算法
 * 最小生成树：普利姆算法、克鲁斯卡尔算法
 * 最短路径：迪杰拉斯算法
 * 拓扑排序
 *
 * @author Johnny Deng
 * @date 2019/11/14 11:12
 * @version 1.0
 */
public class Graph {
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
            min = new TreeNode(-1, -1, Integer.MAX_VALUE);
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
    public int find(int[] path, int index) {
        while (path[index] > 0) {
            index = path[index];
        }
        return index;
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


        // 拓扑排序

    }
}

