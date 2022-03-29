import java.util.*;
public class Graph extends Node{
    LinkedList<Node> nodes; //adj list
    ArrayList<LinkedList<Node>> adjList; //other adj list for bfs
    int[][] matrix;//matrix to traverse throuhg
    Node[] nodeMatrix; //to retrieve the nodes from
    Node[][] adjMatrix; // I added this for Dijkstra
    Set<Node> allNodes; //set of all nodes in the graph
    ArrayList<Edge> edgeList; // Added for BellmanFord algorithm

    public Graph(LinkedList<Node> adj, Set<Node> s){
      nodes = adj;
      allNodes = s;
     }

    public Graph(int[][] m)
    {
       this.matrix = m;
    }

    public Graph(int[][] m, Node[] n)
    {
       matrix = m;
       nodeMatrix = n;

    }
    public Graph(Node[][] g){
        adjMatrix = g;
    }
    public Graph(){

    }
    public Graph(ArrayList<LinkedList<Node>> a){
      adjList = a;
    }

    public ArrayList<LinkedList<Node>> getAdjList(){
      return adjList;
    }


    public Node[] getNodeArray(){
      return nodeMatrix;
    }

    public int[][] getMatrix(){
      return matrix;
    }

    public boolean isListEmpty(){
      return true;
    }

    public boolean isMatrixEmpty(){
       return true;

    }

    public boolean isSetEmpty(){
     return true;

    }

    public void addNode(Node a){
      allNodes.add(a);
    }

    public Node[][] getAdjMatrix(){
      return this.adjMatrix;
    }

    // Returns graph represented by its edges
    public ArrayList<Edge> getEdges(){

      ArrayList<Edge> edgeList = new ArrayList<Edge>();
      // Traverse 2D weight matrix
      for (int start = 0; start < this.matrix.length; start++){
        for (int end = start; end < this.matrix[start].length; end++){
          // Only add an edge if it has a weight (i.e. of not zero)
          if(this.matrix[start][end] != 0){
            edgeList.add( new Edge(start, end, this.matrix[start][end]));
          }
        }
      }
      return edgeList;
    }

    // A class to store a graph edge
   class Edge {
    int source, dest, weight;

    public Edge(int source, int dest, int weight)
    {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    // Overrides the default toString() method so prints out in a readable format
    public String toString(){
      return "("+ this.source+ ", "+this.dest + ", "+this.weight + ")";
    }
}

}
