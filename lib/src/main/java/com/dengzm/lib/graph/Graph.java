package com.dengzm.lib.graph;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @description ͼ���㷨
 * ��С������������ķ�㷨����³˹�����㷨
 * ���·�����Ͻ���˹�㷨�����������㷨��SPFA�㷨
 * ��������
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
     * ����ķ�㷨:������С������
     * ��Ҫ˼·���ǴӺ�ѡ�ڵ���ѡ����С��Ȩֵ��ӵ���С��������
     * ��ϸͼ�ķ�������https://www.cnblogs.com/ludashi/p/5944970.html
     *
     * @return ��С�������ĸ��ڵ�
     */
    public TreeNode prim() {
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0) {
            return null;
        }

        // ��С�������ĸ��ڵ�
        TreeNode result = new TreeNode(0, -1, 0);

        int length = adjacencyMatrix.length;

        // ��СȨֵ
        TreeNode[] lowestCost = new TreeNode[length];

        // ��־�����Ƿ�ת���Ƴ�
        boolean[] isNodeRemoved = new boolean[length];
        isNodeRemoved[0] = true;

        // ��Сֵ����Сֵ�±�
        TreeNode min;
        int minId;

        // Ȩֵ�ܺ�
        // int sum = 0;

        // ���ڽӾ���ĵ�һ�и�ֵ����Сֵ�����г�ʼ��
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
                // �ҵ���ǰ��СȨֵ��������С��һ��
                if (lowestCost[j] != null && lowestCost[j].value > 0 && lowestCost[j].value < min.value) {
                    min = lowestCost[j];
                    minId = j;
                }
            }

            // ��¼Ȩֵ�ܺ�
            // sum += min.value;

            // System.out.println("find a min : " + min.value + ", minId : " + minId);
            // System.out.println("current sum is " + sum);

            // ���ö���ת�����Ƴ�
            lowestCost[minId] = null;
            isNodeRemoved[minId] = true;

            result.addChild(min);

            // ������СȨֵ��
            for (int j = 0; j < length; j ++) {
                if (!isNodeRemoved[j] && adjacencyMatrix[minId][j] > 0) { // �ö���û��ת���Ƴ� �� ���ݴ���0
                    if (lowestCost[j] == null || adjacencyMatrix[minId][j] < lowestCost[j].value) { // �ö���֮ǰû����СȨֵ �� ��ת�����㵽�õ��Ȩֵ��С
                        lowestCost[j] = new TreeNode(j, minId, adjacencyMatrix[minId][j]);
                    }
                }
            }
        }

        return result;
    }

    /**
     * ��³˹�����㷨
     * �Ƚ�ÿ���߰���Ȩֵ��С�����������Ȼ�������ļ������Դ�ȡ����С�ı���ӵ���С�������У�����Ҫ��֤����ӵı�����С�������ϵı߲����ɻ�·
     * ��ϸͼ�ķ�������https://www.cnblogs.com/ludashi/p/5944970.html
     *
     * @return ��С�������ĸ��ڵ�
     */
    public ArrayList<Edge> kruskal() {
        if (edges == null || edges.size() == 0) {
            return null;
        }

        // ��ÿ���߰���Ȩֵ��С�����������
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        // ��С�������ĸ��ڵ�
        ArrayList<Edge> result = new ArrayList<>();

        int length = edges.size();
        // int sum = 0;

        // ·�������Ĺ��ܣ�����˵�ǰ������ֱ�ӵ�����¸�����
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
     * ͨ���ݹ���Ѱ�ң�index�����Ӧ�����һ������
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

    /**
     * �Ͻ�˹�����㷨
     * Dijkstra�㷨ʹ���˹���������������Ȩ����ͼ��������ͼ�ĵ�Դ���·�����⣬�㷨���յõ�һ�����·������
     * ���㷨������·���㷨������Ϊ����ͼ�㷨��һ����ģ�顣
     * ��ϸͼ�ķ�������https://blog.csdn.net/qq_35644234/article/details/60870719
     *
     * @return ���·������
     */
    public int[] dijkstra() {
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0) {
            return null;
        }

        int length = adjacencyMatrix.length;

        // ���·��
        int[] shortestPath = new int[length];

        // �����Ƿ�ȷ��
        boolean[] isNodeRemoved = new boolean[length];
        isNodeRemoved[0] = true;

        System.arraycopy(adjacencyMatrix[0], 0, shortestPath, 0, length);

        int min, minId;

        for (int i = 0; i < length; i ++) {
            min = Integer.MAX_VALUE;
            minId = -1;

            // �ҵ���ǰ���·���У�δ��ȷ�ϵ����·��
            for (int j = 0; j < length; j ++) {
                if (!isNodeRemoved[j] && shortestPath[j] != 0 && shortestPath[j] < min) {
                    min = shortestPath[j];
                    minId = j;
                }
            }

            // δ�ҵ��������е��Ѿ�ѭ����ϣ�����
            if (minId == -1) {
                return shortestPath;
            }

            // �����õ㵽������ľ��룬���ϸõ㵽��ʼ�����̾��룬���С�ڵ�ǰ���·���������
            for (int j = 0; j < length; j ++) {
                if (!isNodeRemoved[j] && adjacencyMatrix[minId][j] != 0 &&
                        (shortestPath[j] == 0 || shortestPath[minId] + adjacencyMatrix[minId][j] < shortestPath[j])) {
                    shortestPath[j] = shortestPath[minId] + adjacencyMatrix[minId][j];
                }
            }

            // ���õ�ת��
            isNodeRemoved[minId] = true;
        }

        return shortestPath;
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

        //������������������������������������������������������������������������

        // ����ķ�㷨
        System.out.println("��������  Prim  ��������");
        TreeNode primRoot = graph.prim();
        primRoot.printTree();
        System.out.println("������������������������");
        System.out.println();

        // ��³˹�����㷨
        System.out.println("��������  Kruskal  ��������");
        ArrayList<Edge> kruskalRoot = graph.kruskal();
        for (Edge edge : kruskalRoot) {
            System.out.println("Edge : begin " + edge.begin + " end " + edge.end + " , weight is " + edge.weight);
        }
        System.out.println("������������������������");
        System.out.println();

        // �Ͻ���˹�㷨
        System.out.println("��������  Dijkstra  ��������");
         int[] dijkstraRoot = graph.dijkstra();
        for (int value : dijkstraRoot) {
            System.out.println(value + " ");
        }
        System.out.println("������������������������");
        System.out.println();

        //���������㷨


        //SPFA�㷨


        // ��������

    }
}

