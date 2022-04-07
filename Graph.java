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

    //Dijkstra
    public static ArrayList<Integer> shortestPath = new ArrayList<>(); //dijkstra
    public Map<Integer, Node> graph = new HashMap<>(); // mapping of Node ids to Node objects, built from a set of Edges

    public static class Node implements Comparable<Node>{
        public int id;
        public int distance = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
        public Node previous = null;
        public final Map<Node, Integer> neighbours = new HashMap<>();

        public Node(int id)
        {
            this.id = id;
        }

        private void printPath()
        {
            if (this == this.previous)
            {
                System.out.printf("%s", this.id);
            }
            else if (this.previous == null)
            {
                System.out.printf("%s(unreached)", this.id);
            }
            else
            {
                this.previous.printPath();
                System.out.printf(" -> %s(%d)", this.id, this.distance);
            }
        }

        public int compareTo(Node other)

        {

            if (distance == other.distance) {
                if (id == other.id) {
                    return 0;
                } else if(id < other.id){
                    return -1;
                } else if(id > other.id){
                    return 1;
                }
                //    return id.compareTo((Integer)other.id); }
            }
            return Integer.compare(distance, other.distance);
        }
    }
    public Graph(Edge[] edges) {
        graph = new HashMap<>(edges.length);

        //one pass to find all vertices
        for (Edge e : edges) {
            if (!graph.containsKey(e.source)) graph.put(e.source, new Node(e.source));
            if (!graph.containsKey(e.dest)) graph.put(e.dest, new Node(e.dest));
        }

        //another pass to set neighbouring vertices
        for (Edge e : edges) {
            graph.get(e.source).neighbours.put(graph.get(e.dest), e.distance);
            //graph.get(e.dest).neighbours.put(graph.get(e.source), e.distanceance); // also do this for an undirected graph
        }
    }
    public void printEdges(){
        for ( Integer key : graph.keySet() ) {
            System.out.println( key );
        }
    }

    public void printPath(int endid) {
        if (!graph.containsKey(endid)) {
            System.err.printf("Graph doesn't contain end Node \"%s\"\n", endid);
            return;
        }

        graph.get(endid).printPath();
        System.out.println();
    }

    public void dijkstra(int startid) {
        if (!graph.containsKey(startid)) {
            System.err.printf("Graph doesn't contain start Node \"%s\"\n", startid);
            return;
        }
        final Node source = graph.get(startid);
        NavigableSet<Node> q = new TreeSet<>();

        // set-up vertices
        for (Node v : graph.values()) {
            v.previous = v == source ? source : null;
            v.distance = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    /**
     * Implementation of dijkstra's algorithm using a binary heap.
     */

    private void dijkstra(NavigableSet<Node> q) {
        Node u, v;
        while (!q.isEmpty()) {

            u = q.pollFirst(); // Node with shortest distanceance (first iteration will return source)
            if (u.distance == Integer.MAX_VALUE)
                break; // we can ignore u (and any other remaining vertices) since they are unreachable

            //look at distanceances to each neighbour
            for (Map.Entry<Node, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //the neighbour in this iteration

                final int alternatedistance = u.distance + a.getValue();
                if (alternatedistance < v.distance) { // shorter path to neighbour found
                    q.remove(v);
                    v.distance = alternatedistance;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }
    public static class Edge extends Node {
        int source, dest, weight;

        public Edge(int source, int dest, int weight)
        {
            super(source);
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
        // Returns graph represented by its edges


        // A class to store a graph edge



        // Overrides the default toString() method so prints out in a readable format
        public String toString(){
            return "("+ this.source+ ", "+this.dest + ", "+this.weight + ")";
        }
    }
    //end of dijkstra



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