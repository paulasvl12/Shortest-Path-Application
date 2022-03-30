package com.example.pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {


    public static class Edge {
        Edge(int weight, Node node) {
            this.weight = weight;
            this.node = node;
        }

        public int weight;
        public Node node;

    }


}
