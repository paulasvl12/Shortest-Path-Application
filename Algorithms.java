import java.util.*;

public class Algorithms extends GUIWindow {
    private int source;
    private int end;
    private Graph graphtwo;
    private Node[][] graph;
    private ArrayList<LinkedList<Node>> adjList;

    public int getSource(){
        return source;
    }

    public void setSource(int s){
        source = s;
    }

    public int getEnd(){
        return end;
    }

    public void setEnd(int e){
        end = e;
    }

    public Node[][] getGraph(){
        return graph;
    }

    public void setGraph(Node[][] g){
        graph = g;
    }

    // start method : given String which is name of the algorithm

    // *******     Fix <Edge> class issue                  ******/
    // public static void start(String algorithm, Node[][] graph, int source, int end, Graph g, Node s, Node e,
    //                          int n){
    //     if(algorithm.equalsIgnoreCase("AStar") || algorithm.equalsIgnoreCase("Select Algorithm") ){
    //         AStar a = new AStar();
    //         a.AStar(graph, source, end);
    //     } else if(algorithm.equalsIgnoreCase("BellmanFord")){
    //       g.updateMatrix();
    //       ArrayList<Edge> edges = g.getEdges();
    //       bellmanfordRunner b = new bellmanfordRunner();
    //       b.runBellmanFordAlgorithm(edges, start.getID(), 35, end.getID());
    //     } else if(algorithm.equalsIgnoreCase("Bidirectional Search")){
    //         BidirectionalSearch b = new BidirectionalSearch();
    //         b.biDirectionalSearch(g, s, e);
    //     } else if(algorithm.equalsIgnoreCase("Breadth-First Search")){
    //         BFS b = new BFS();
    //         b.traversal(g, s, e);
    //     } else if(algorithm.equalsIgnoreCase("Dijkstra")){
    //         Dijkstra1 d = new Dijkstra1();
    //         d.dijkstra(graph, source, end);
    //     }
    // }

     public static void start(String algorithm, Node[][] graph, int source, int end, Graph g, Node s, Node e,
                             ArrayList<Node> allCells, int n, int[][] aStarGraph){
        if(algorithm.equalsIgnoreCase("AStar") || algorithm.equalsIgnoreCase("Select Algorithm") ){
            AStar a = new AStar(aStarGraph, s, e);
            a.findPath();
        } else if(algorithm.equalsIgnoreCase("BellmanFord")){
          // Update matrix with cell information
          g.updateMatrix();
          // Get the edges between all the nodes
          ArrayList<Edge> edges = g.getEdges();
          // Run Bellman Ford
          bellmanfordRunner b = new bellmanfordRunner();
          b.runBellmanFordAlgorithm(edges, s.getID(), 35, e.getID());
          bellmanfordRunner bell = new bellmanfordRunner();
          bell.runBellmanFordAlgorithm(edges, source, n, end);
          
        } else if(algorithm.equalsIgnoreCase("Bidirectional Search")){
            BidirectionalSearch bi = new BidirectionalSearch();
            bi.biDirectionalSearch(s, e, g);
        } else if(algorithm.equalsIgnoreCase("Breadth-First Search")){
            BreadthFirstSearch b = new BreadthFirstSearch();
            b.traversal(s, e, g);
        } else if(algorithm.equalsIgnoreCase("Dijkstra")){
            Dijkstra1 d = new Dijkstra1();
            d.dijkstra(graph, source, end);
	    }
    }
}

   