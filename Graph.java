import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph extends Node {

   public static int weight;
   public static Node node;
   public List<Graph> neighbors;

   public Graph(int weight, Node node){
      this.weight = weight;
      this.node = node;
   }
        
    public void addBranch(int weight, Node node){
         Graph newGraph = new Graph(weight, node);
         neighbors.add(newGraph);
                   
    }
    
    public double calculateHeuristic(Node target){
      return this.h;
    }

}
