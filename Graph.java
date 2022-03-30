import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph extends Node {
    public ArrayList<Edge> neighbors;

    public Edge(int weight, Node node) {
        this.weight = weight;
        this.node = node;
        this.neighbors = new ArrayList<>();

    }

    public int weight;
    public Node node;

}



