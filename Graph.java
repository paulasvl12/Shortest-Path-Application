import java.util.*;
public class Graph extends Node{
    LinkedList<Node> nodes; //adj list
    ArrayList<LinkedList<Node>> adjList; //other adj list for bfs
    int[][] matrix;//matrix to traverse throuhg
    Node[] nodeMatrix; //to retrieve the nodes from
    Node[][] adjMatrix; // I added this for Dijkstra
    Set<Node> allNodes; //set of all nodes in the graph
    
    public Graph(LinkedList<Node> adj, Set<Node> s){
      nodes = adj;
      allNodes = s;
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
    
}
