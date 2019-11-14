package com.dengzm.lib.graph;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description class for Kruskal
 * @date 2019/11/14 13:09
 */
public class Edge {
    public int begin;
    public int end;
    public int weight;

    public Edge(int begin, int end, int weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }
}
