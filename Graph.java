import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph extends Node {
<<<<<<< Updated upstream

   public Graph(int h, Node n) {
          
   }

    public static ArrayList<Graph> neighbors;
    public int weight;
    public Node node;

    public void Graph(int weight, Node node) {
        this.weight = weight;
        this.node = node;
        this.neighbors = new ArrayList<>();

    }
    
    public void addBranch(int weight, Node node){
         Graph newGraph = new Graph(weight, node);
         neighbors.add(newGraph);
    
    }


}



=======
   int[][] adjMatrix;
   ArrayList<Edge> edgeList;
   
   
   public Graph(int[][] g) {
      adjMatrix = g;
   }
   
   public int[][] getAdjMatrix(){
      return this.adjMatrix;
   }
   
   ArrayList<Edge> getEdges(){
      ArrayList<Edge> edgeList = new ArrayList<Edge>();
      
      for(int start = 0; start < this.adjMatrix.length; start++){
         for(int end = start; end < this.adjMatrix[start].length; end++){
            if(this.adjMatrix[start][end] != 0){
               edgeList.add(new Edge(start, end, this.adjMatrix[start][end]));
            }
         }
      }
      
      return edgeList;
   }
   
   class Edge {
   int source, dest, weight;
   
   public Edge(int source, int dest, int weight){
      this.source = source;
      this.dest = dest;
      this.weight = weight;
   }
   
   }
}
>>>>>>> Stashed changes
