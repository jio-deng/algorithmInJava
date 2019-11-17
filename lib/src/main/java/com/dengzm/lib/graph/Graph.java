package com.dengzm.lib.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

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
    public static final int MAX = Integer.MAX_VALUE;

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
            min = new TreeNode(-1, -1, MAX);
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
    private int find(int[] path, int index) {
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
            min = MAX;
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


    /**
     * Floyd�㷨
     *
     * ��ϸͼ�ķ�������
     * 1.https://www.cnblogs.com/wangyuliang/p/9216365.html
     * 2.https://blog.csdn.net/qq_35644234/article/details/60875818
     */
    public int[][] floyd() {
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0) {
            return null;
        }

        int length = adjacencyMatrix.length;

        // ��̾���
        int[][] distance = new int[length][length];

        // ��̾����������ĵ�
        // int[][] path = new int[length][length];

        // �С��С���ǰ��ʼ���㡢��ǰֵ(�жϵ�ǰֵ�Ƿ�Ϊ�����)
        int row, col, vertex, select;

        // init data
        for (row = 0; row < length; row ++) {
            for (col = 0; col < length; col ++) {
                distance[row][col] = adjacencyMatrix[row][col];
                // path[row][col] = col;
            }
        }

        /**
         * ���Ĵ��룺����ѭ��
         * ��������ֻ������1�Ŷ��㣬����������֮������·�̣�Ӧ��������أ�
         * ֻ���ж�e[i][1]+e[1][j]�Ƿ��e[i][j]ҪС����,e[i][j]��ʾ���Ǵ�i�Ŷ��㵽j�Ŷ���֮���·�̡�
         * e[i][1]+e[1][j]��ʾ���Ǵ�i�Ŷ����ȵ�1�Ŷ��㣬�ٴ�1�Ŷ��㵽j�Ŷ����·��֮�͡�����i��1~nѭ����jҲ��1~nѭ����
         * �������е㣬�����Ծ�������һ�㣬�����������vertex��ѭ����
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
     * SPFA�㷨
     * ������dis��¼ÿ���������·������ֵ�����ڽӱ���ڽӾ������洢ͼG��
     * ��ȡ�ķ����Ƕ�̬�ƽ���������һ���Ƚ��ȳ��Ķ�������������Ż��Ľ�㣬�Ż�ʱÿ��ȡ�����׽��u��
     * ������u�㵱ǰ�����·������ֵ���뿪u����ָ��Ľ��v�����ɳڲ��������v������·������ֵ����������
     * ��v�㲻�ڵ�ǰ�Ķ����У��ͽ�v������β���������ϴӶ�����ȡ������������ɳڲ�����ֱ�����п�Ϊֹ
     *
     * ��ϸͼ�ķ�������https://blog.csdn.net/qq_35644234/article/details/61614581
     */
    public int[] spfa() {
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0) {
            return null;
        }

        int length = adjacencyMatrix.length;

        // ���·��
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

            // �����õ㵽������ľ��룬���ϸõ㵽��ʼ�����̾��룬���С�ڵ�ǰ���·���������
            for (int i = 0; i < length; i ++) {
                if (adjacencyMatrix[vertex][i] != 0 && // ��һ�еģ�i != 0������ӵ�ԭ��Ϊ���ҵĲ�������Ĭ��0Ϊ���ֵ�ˣ�Ϊ�˲��õ�һ��0���ӵ������У�����������������
                        ((shortestPath[i] == 0 && i != 0) || shortestPath[vertex] + adjacencyMatrix[vertex][i] < shortestPath[i])) {
                    shortestPath[i] = shortestPath[vertex] + adjacencyMatrix[vertex][i];

                    // �ɳں�����õ㲻�ڶ��У���������
                    if (!queue.contains(i)) {
                        queue.add(i);
                    }
                }
            }
        }

        return shortestPath;
    }

    /**
     * ��������
     *
     * ��ϸͼ�ķ�������https://blog.csdn.net/qq_41713256/article/details/80805338
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
        System.out.println("��������  Floyd  ��������");
        int[][] floyd = graph.floyd();
        for (int row = 0; row < floyd.length; row ++) {
            for (int col = 0; col < floyd.length; col ++) {
                System.out.print(floyd[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("������������������������");
        System.out.println();

        //SPFA�㷨
        System.out.println("��������  SPFA  ��������");
        int[] spfa = graph.spfa();
        for (int value : spfa) {
            System.out.println(value + " ");
        }
        System.out.println("������������������������");
        System.out.println();

        // ��������
        graph.adjacencyMatrix = data2;
        System.out.println("��������  Topological Sorting  ��������");
        ArrayList<Integer> topologicalSorting = graph.topologicalSorting();
        for (int value : topologicalSorting) {
            System.out.println(value + " ");
        }
        System.out.println("������������������������");
        System.out.println();
    }
}

