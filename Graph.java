import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph extends Node {

   public Graph(int h, Node n) {
          
       }

    public static ArrayList<Graph> neighbors;
    public int weight;
    public Node node;

    public void Edge(int weight, Node node) {
        this.weight = weight;
        this.node = node;
        this.neighbors = new ArrayList<>();

    }
    
    public void addBranch(int weight, Node node){
         Graph newGraph = new Graph(weight, node);
         neighbors.add(newGraph);
    
    }


}



