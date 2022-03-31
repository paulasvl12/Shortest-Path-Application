import java.util.*;
public class Graph extends Node {

    LinkedList<Node> nodes; //adj list
    ArrayList<LinkedList<Node>> adjList; //other adj list for bfs
    int[][] matrix;//matrix to traverse throuhg
    Node[] nodeMatrix; //to retrieve the nodes from
    Node[][] adjMatrix; // I added this for Dijkstra
    Set<Node> allNodes; //set of all nodes in the graph
    ArrayList<Node> nodeList; // Added for BellmanFord algorithm
    ArrayList<Edge> edgeList; // Added for BellmanFord algorithm

   
     
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

    //This is the constructor the GUI should use
    public Graph(ArrayList<LinkedList<Node>> a, ArrayList<Node> nodeList){
      adjList = a;
      this.nodeList = nodeList;
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

    public void updateMatrix() {
      
      // Starting matrix for Bellman Ford
      int[][] matrix = {
        {0, 2, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 3, 2, 3},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 2, 0}
      };
      
      // Loop to update the matrix when there are obstructions
      for(int i = 0; i< this.nodeList.size(); i++){
        if(this.nodeList.get(i).getState() == "Obs"){
          int nodeRow = this.nodeList.get(i).getRow();
          int nodeCol = this.nodeList.get(i).getCol();

          for (int column = 0; i < 35; column++){
            matrix[nodeRow][column] = 0;
          }
          for (int row = 0; i < 35; row++){
            matrix[row][nodeCol] = 0;
          }
          
        }
      }
      
      this.matrix = matrix;
    }

    // Returns graph represented by its edges
    /*public ArrayList<Edge> getEdges(){

      ArrayList<Edge> edgeList = new ArrayList<Edge>();
      
      // Traverse 2D weight matrix
      for (int start = 0; start < this.matrix.length; start++){
      
        for (int end = 0; end < this.matrix[start].length; end++){
        
          // Only add an edge if it has a weight (i.e. of not zero)
          if(this.matrix[start][end] != 0){
            edgeList.add( new Edge(start, end, this.matrix[start][end]));
          }
        }
      }
      
      return edgeList;
    }*/

}